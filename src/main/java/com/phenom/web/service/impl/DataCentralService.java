package com.phenom.web.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.phenom.common.constant.UserConstant;
import com.phenom.common.enums.ResultCode;
import com.phenom.common.exception.BizException;
import com.phenom.common.utils.AjaxResult;
import com.phenom.common.utils.AppTokenResult;
import com.phenom.common.utils.SignUtil;
import com.phenom.web.domain.SysEmployee;
import com.phenom.web.domain.dto.DataCentralEmpInfoDto;
import com.phenom.web.domain.vo.SysEmployeeVo;
import com.phenom.web.service.SysEmployeeService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataCentralService {

    @Value("${dataCentral.tenantId}")
    private Long tenantId;

    @Value("${dataCentral.empInfoUrl}")
    private String empInfoUrl;

    @Value("${dataCentral.appKey}")
    private String appkey;

    @Value("${dataCentral.getTokenUrl}")
    private String getTokenUrl;

    @Value("${dataCentral.secret}")
    private String secret;

    @Resource
    private SysEmployeeService sysEmployeeService;


    /**
     * 数据中台员工信息同步
     * @param dateStr 同步指定日期数据(为空时表示同步所有日期的数据)
     */
    public void syncEmpInfo(String dateStr) {
        DataCentralEmpInfoDto empInfoDTO = new DataCentralEmpInfoDto();
        empInfoDTO.setUpdateTime(dateStr);
        empInfoDTO.setTenantId(tenantId);
        // 获取中台员工列表
        List<DataCentralEmpInfoDto> empInfoDTOList = this.getEmpInfoList(empInfoDTO);
        if(!CollectionUtils.isEmpty(empInfoDTOList)){
            for (DataCentralEmpInfoDto item : empInfoDTOList) {
                // 中台员工信息转为工单员工信息
                SysEmployee sysEmp = new SysEmployee();
                BeanUtils.copyProperties(item, sysEmp);
                if (DataCentralEmpInfoDto.ON_JOB_STATUS_NO.equals(item.getOnJobStatus())) {
                    sysEmp.setStatus(UserConstant.DISABLE);
                }else{
                    sysEmp.setStatus(UserConstant.ENABLE);
                }
                sysEmp.setCreateBy(UserConstant.SYS_USER);
                sysEmp.setUpdateBy(UserConstant.SYS_USER);

                // 保存信息：先查询是否已存在，存在更新，不存在插入
                SysEmployeeVo sysEmployeeVo = sysEmployeeService.selectSysEmpByUserName(item.getUserName());
                if(sysEmployeeVo == null){
                    sysEmployeeService.insertSysEmp(sysEmp);
                }else{
                    sysEmp.setId(sysEmployeeVo.getId());
                    sysEmployeeService.updateSysEmpById(sysEmp);
                }
            }
        }
    }

    /**
     * 获取人员信息
     * @param empInfoDTO
     * @return
     */
    private List<DataCentralEmpInfoDto> getEmpInfoList(DataCentralEmpInfoDto empInfoDTO) {
        String params = JSONObject.toJSONString(empInfoDTO);
        HttpRequest request = HttpUtil.createPost(empInfoUrl);
        request.addHeaders(buildHeader(params)).body(params);
        HttpResponse response = request.execute();
        // 处理响应
        if(response.isOk()){
            AjaxResult ajaxResult = JSON.parseObject(response.body(), AjaxResult.class);
            if(MapUtils.getInteger(ajaxResult, AjaxResult.CODE_TAG) != 0){
                throw new BizException(ResultCode.ERROR.getCode(), "数据获取失败：" + ajaxResult.get(AjaxResult.MSG_TAG));
            }
            return JSON.parseArray(MapUtils.getString(ajaxResult, AjaxResult.DATA_TAG), DataCentralEmpInfoDto.class);
        } else {
            throw new BizException(ResultCode.ERROR.getCode(), "数据获取失败!");
        }
    }

    /**
     * 构建请求头
     * @param params
     * @return
     */
    private Map<String, String> buildHeader(String params) {
        String token = getToken();
        Map<String,String> headers = new HashMap<>(8);
        String timestamp = String.valueOf(System.currentTimeMillis());
        headers.put("token", token);
        headers.put("appkey", appkey);
        headers.put("timestamp", timestamp);
        JSONObject jsonObject = (params == null) ? new JSONObject() : JSON.parseObject(params);
        try {
            headers.put("sign", SignUtil.signTopRequest(jsonObject, secret, token, SignUtil.SIGN_METHOD_MD5,timestamp));
        } catch (IOException e) {
            throw new BizException(ResultCode.SIGN_CREATE_FAIL.getCode(), "签名创建异常！");
        }
        return headers;
    }

    /**
     * 获取中台token
     * @return
     */
    private String getToken() {
        HttpRequest request = HttpUtil.createGet(getTokenUrl);
        HttpResponse response = request.execute();
        if(response.isOk()){
            AppTokenResult result = JSONObject.parseObject(response.body(), AppTokenResult.class);
            if(result.getCode() != 0){
                throw new BizException(ResultCode.ERROR.getCode(), "获取中台token异常！");
            }
            return result.getToken();
        }else{
            throw new BizException(ResultCode.ERROR.getCode(), "获取中台token异常！");
        }
    }
}

