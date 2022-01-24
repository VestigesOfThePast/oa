package com.phenom.web.service.impl;

import com.phenom.web.domain.vo.SysMenuVo;
import org.springframework.stereotype.Service;
import com.phenom.web.mapper.SysMenuMapper;
import com.phenom.web.domain.SysMenu;
import com.phenom.web.service.SysMenuService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl implements SysMenuService{

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public int deleteByPrimaryKey(Long menuId) {
        return sysMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insert(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    @Override
    public SysMenu selectByPrimaryKey(Long menuId) {
        return sysMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKey(record);
    }

    /**
     * 获取下拉菜单树
     * @param menu
     * @return
     */
    @Override
    public List<SysMenuVo> treeSelect(SysMenu menu) {
        List<SysMenuVo> resultList = new ArrayList<>();
        List<SysMenuVo> sysMenuVoList = null;
        //条件下全部菜单
        sysMenuVoList = sysMenuMapper.selectTree(menu);
        // 先定位所有的一级菜单
        resultList = sysMenuVoList.stream().filter(item-> item.getParentId()==0).collect(Collectors.toList());
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SysMenuVo sysMenuVo : resultList) {
            sysMenuVo.setChildrenMenus(getChild(sysMenuVo.getMenuId(), sysMenuVoList));
        }
        return resultList;
    }

    /**
     * 递归查找子菜单
     * @param menuId    当前菜单id
     * @param sysMenuVoList 要查找的列表
     * @return
     */
    private List<SysMenuVo> getChild(long menuId, List<SysMenuVo> sysMenuVoList) {
        // 子菜单
        List<SysMenuVo> childList = new ArrayList<>();
        for (SysMenuVo sysMenuVo : sysMenuVoList) {
            // 遍历所有节点，将父菜单id与传过来的全部菜单的父id比较
            if (sysMenuVo.getParentId() != null) {
                if (sysMenuVo.getParentId().equals(menuId)) {
                    childList.add(sysMenuVo);
                }
            }
        }
        // 把子菜单的子菜单再遍历一次
        for (SysMenuVo sysMenuVo: childList) {
            // 递归
            sysMenuVo.setChildrenMenus(getChild(sysMenuVo.getMenuId(), sysMenuVoList));
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
