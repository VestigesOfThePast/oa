package com.phenom.web.domain;

import lombok.Data;

import java.util.Date;

/**
  * 菜单权限表
 */
@Data
public class SysMenu {
    /**
    * 菜单ID
    */
    private Long menuId;

    /**
    * 菜单名称
    */
    private String menuName;

    /**
    * 父菜单ID
    */
    private Long parentId;

    /**
    * 显示顺序
    */
    private Integer orderNum;

    /**
    * 路由地址
    */
    private String path;

    /**
    * 组件路径
    */
    private String component;

    /**
    * 是否为外链（0是 1否）
    */
    private Integer isFrame;

    /**
    * 菜单类型（M目录 C菜单 F按钮）
    */
    private String menuType;

    /**
    * 菜单状态（0显示 1隐藏）
    */
    private String visible;

    /**
    * 菜单状态（0正常 1停用）
    */
    private String status;

    /**
    * 权限标识
    */
    private String perms;

    /**
    * 菜单图标
    */
    private String icon;

    /**
    * 创建者
    */
    private String createBy;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新者
    */
    private String updateBy;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 备注
    */
    private String remark;


    public static final class SysMenuBuilder {
        private Long menuId;
        private String menuName;
        private Long parentId;
        private Integer orderNum;
        private String path;
        private String component;
        private Integer isFrame;
        private String menuType;
        private String visible;
        private String status;
        private String perms;
        private String icon;
        private String createBy;
        private Date createTime;
        private String updateBy;
        private Date updateTime;
        private String remark;

        private SysMenuBuilder() {
        }

        public static SysMenuBuilder aSysMenu() {
            return new SysMenuBuilder();
        }

        public SysMenuBuilder menuId(Long menuId) {
            this.menuId = menuId;
            return this;
        }

        public SysMenuBuilder menuName(String menuName) {
            this.menuName = menuName;
            return this;
        }

        public SysMenuBuilder parentId(Long parentId) {
            this.parentId = parentId;
            return this;
        }

        public SysMenuBuilder orderNum(Integer orderNum) {
            this.orderNum = orderNum;
            return this;
        }

        public SysMenuBuilder path(String path) {
            this.path = path;
            return this;
        }

        public SysMenuBuilder component(String component) {
            this.component = component;
            return this;
        }

        public SysMenuBuilder isFrame(Integer isFrame) {
            this.isFrame = isFrame;
            return this;
        }

        public SysMenuBuilder menuType(String menuType) {
            this.menuType = menuType;
            return this;
        }

        public SysMenuBuilder visible(String visible) {
            this.visible = visible;
            return this;
        }

        public SysMenuBuilder status(String status) {
            this.status = status;
            return this;
        }

        public SysMenuBuilder perms(String perms) {
            this.perms = perms;
            return this;
        }

        public SysMenuBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public SysMenuBuilder createBy(String createBy) {
            this.createBy = createBy;
            return this;
        }

        public SysMenuBuilder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public SysMenuBuilder updateBy(String updateBy) {
            this.updateBy = updateBy;
            return this;
        }

        public SysMenuBuilder updateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public SysMenuBuilder remark(String remark) {
            this.remark = remark;
            return this;
        }

        public SysMenu build() {
            SysMenu sysMenu = new SysMenu();
            sysMenu.setMenuId(menuId);
            sysMenu.setMenuName(menuName);
            sysMenu.setParentId(parentId);
            sysMenu.setOrderNum(orderNum);
            sysMenu.setPath(path);
            sysMenu.setComponent(component);
            sysMenu.setIsFrame(isFrame);
            sysMenu.setMenuType(menuType);
            sysMenu.setVisible(visible);
            sysMenu.setStatus(status);
            sysMenu.setPerms(perms);
            sysMenu.setIcon(icon);
            sysMenu.setCreateBy(createBy);
            sysMenu.setCreateTime(createTime);
            sysMenu.setUpdateBy(updateBy);
            sysMenu.setUpdateTime(updateTime);
            sysMenu.setRemark(remark);
            return sysMenu;
        }
    }

}