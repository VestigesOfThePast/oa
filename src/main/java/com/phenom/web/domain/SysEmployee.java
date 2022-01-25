package com.phenom.web.domain;
import lombok.Data;
import java.io.Serializable;

/**
 * 员工模型
 * @author olic
 * @date 2022/1/251:01 下午
 */
@Data
public class SysEmployee extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1L;

    /** 员工id */
    private Long id;
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
    /** 状态:1正常 0停用 */
    private Byte status;
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
}

