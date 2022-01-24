package com.phenom.web.domain.dto;

import lombok.Data;

/**
 * 数据中台员工信息模型
 * @Author lsh
 * @Date 2022/2/24
 * @Version 1.1
 */
@Data
public class DataCentralEmpInfoDto {
    /** 在职状态：在职1，离职2 */
    public static final String ON_JOB_STATUS_YES = "1",ON_JOB_STATUS_NO = "2";

    /** 中台员工id */
    private Long empId;
    /** 用户名 */
    private String userName;
    /** 工号 */
    private String empCode;
    /** 员工姓名 */
    private String empName;
    /** 性别1男2女 */
    private Integer sex;
    /** 手机号 */
    private String phone;
    /** 邮箱 */
    private String email;
    /** 上级用户名 */
    private String report;
    /** 状态:1在职 2离职 */
    private String onJobStatus;
    /** 职称Code */
    private String positionCode;
    /** 职称名称 */
    private String positionName;
    /** 职级id */
    private String rankId;
    /** 职级名称 */
    private String rankName;
    /** 组织id */
    private String orgId;
    /** 组织名称 */
    private String orgName;
    /** 租户id */
    private Long tenantId;
    /** 更新时间(获取增量组织用:yyyy-MM-dd) */
    private String updateTime;
}
