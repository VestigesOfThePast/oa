package com.phenom.web.controller;

import com.phenom.common.utils.Result;
import com.phenom.web.domain.SysMenu;
import com.phenom.web.domain.vo.SysMenuVo;
import com.phenom.web.service.SysMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单信息
 * @author lsh
 */
@RestController
@RequestMapping("/system/menu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 获取下拉菜单树
     * @param menu
     * @return
     */
    @GetMapping
    public Result treeSelect(SysMenu menu) {
        List<SysMenuVo> sysMenuList = sysMenuService.treeSelect(menu);
        return Result.success(sysMenuList);
    }

}
