package com.phenom.web.service;

import com.phenom.web.domain.SysMenu;
import com.phenom.web.domain.vo.SysMenuVo;

import java.util.List;

public interface SysMenuService{

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenuVo> treeSelect(SysMenu menu);

}
