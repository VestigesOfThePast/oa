package com.phenom.web.mapper;

import com.phenom.web.domain.SysEmployee;
import com.phenom.web.domain.bo.SysEmployeeBo;
import com.phenom.web.domain.vo.SysEmployeeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author olic
 * @date 2022/1/251:14 下午
 */
@Mapper
public interface SysEmployeeMapper {


    /**
     * 根据userName查询员工信息
     * @param userName userName
     * @return 员工信息
     */
    SysEmployeeVo selectSysEmpByUserName(String userName);

    /**
     * 根据条件获取员工信息列表
     * @param sysEmpBO 查询条件
     * @return 员工信息列表
     */
    List<SysEmployeeVo> selectSysEmpList(SysEmployeeBo sysEmpBO);

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
