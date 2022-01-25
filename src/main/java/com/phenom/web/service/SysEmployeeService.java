package com.phenom.web.service;

import com.phenom.web.domain.SysEmployee;
import com.phenom.web.domain.bo.SysEmployeeBo;
import com.phenom.web.domain.vo.SysEmployeeVo;

import java.util.List;

/**
 * 员工 service接口
 * @author olic
 * @date 2022/1/251:04 下午
 */
public interface SysEmployeeService {

    /**
     * 根据userName查询员工信息
     * @param userName userName
     * @return 员工信息
     */
    SysEmployeeVo selectSysEmpByUserName(String userName);

    /**
     * 根据条件获取员工信息列表
     * @param sysEmpBo 查询条件
     * @return 员工信息列表
     */
    List<SysEmployeeVo> selectSysEmpList(SysEmployeeBo sysEmpBo);

    /**
     * 插入员工信息
     * @param sysEmp 员工信息
     * @return 数量
     */
    int insertSysEmp(SysEmployee sysEmp);

    /**
     * 更新员工信息
     * @param sysEmp 员工信息
     * @return 数量
     */
    int updateSysEmpById(SysEmployee sysEmp);

    /**
     * 批量插入员工信息（重复时更新）
     * @param sysEmps 员工列表
     */
    void batchInsertSysEmp(List<SysEmployee> sysEmps);
}

