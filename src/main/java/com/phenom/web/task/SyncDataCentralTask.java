package com.phenom.web.task;

import com.phenom.web.service.impl.DataCentralService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * @ClassName: SyncDataCenterTask
 * @Author: lsh
 * @Description: 同步中台账号数据任务
 * @Date: 2022/1/24
 */
@Slf4j
@Component
public class SyncDataCentralTask {

    @Resource
    private DataCentralService dataCentralService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * 同步中台员工数据
     * @param param
     * @return
     */
    @XxlJob("syncEmployeeInfo")
    public ReturnT<String> syncEmpInfoJobHandler(String param){
        log.info("-----人员信息同步开始--------");
        try {
            dataCentralService.syncEmpInfo(null);
        } catch (Exception e) {
            log.error("同步中台员工数据到sys_emp任务执行失败'ERROR: {}", e.getMessage());
            return new ReturnT(ReturnT.FAIL_CODE,e.getMessage());
        }
        log.info("-----人员信息同步结束--------");
        return ReturnT.SUCCESS;
    }
}
