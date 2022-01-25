package com.phenom.web.service.impl;

import com.phenom.web.domain.SysEmployee;
import com.phenom.web.domain.bo.SysEmployeeBo;
import com.phenom.web.domain.vo.SysEmployeeVo;
import com.phenom.web.mapper.SysEmployeeMapper;
import com.phenom.web.service.SysEmployeeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * 员工serive 实现
 * @author olic
 * @date 2022/1/251:10 下午
 */
@Service
public class SysEmployeeServiceImpl implements SysEmployeeService {

    @Resource
    private SysEmployeeMapper sysEmpMapper;

    /**
     * 根据userName查询员工信息
     * @param userName userName
     * @return 员工信息
     */
    @Override
    public SysEmployeeVo selectSysEmpByUserName(String userName){
        return sysEmpMapper.selectSysEmpByUserName(userName);
    }

    /**
     * 根据条件获取员工信息列表
     * @param sysEmpBo 查询条件
     * @return 员工信息列表
     */
    @Override
    public List<SysEmployeeVo> selectSysEmpList(SysEmployeeBo sysEmpBo) {
        return sysEmpMapper.selectSysEmpList(sysEmpBo);
    }

    /**
     * 插入员工信息
     * @param sysEmp 员工信息
     * @return 数量
     */
    @Override
    public int insertSysEmp(SysEmployee sysEmp) {
        return sysEmpMapper.insertSysEmp(sysEmp);
    }

    /**
     * 更新员工信息
     * @param sysEmp 员工信息
     * @return 数量
     */
    @Override
    public int updateSysEmpById(SysEmployee sysEmp) {
        return sysEmpMapper.updateSysEmpById(sysEmp);
    }

    /**
     * 批量插入员工信息（重复时更新）
     * @param sysEmps 员工列表
     */
    @Override
    public void batchInsertSysEmp(List<SysEmployee> sysEmps) {
        sysEmpMapper.batchInsertSysEmp(sysEmps);
    }
}
