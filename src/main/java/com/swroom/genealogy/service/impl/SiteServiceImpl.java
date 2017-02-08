package com.swroom.genealogy.service.impl;

import com.swroom.genealogy.mapper.SiteMenuMapper;
import com.swroom.genealogy.model.po.SiteMenu;
import com.swroom.genealogy.model.vo.VMenu;
import com.swroom.genealogy.service.SiteService;
import com.swroom.genealogy.service.common.MenuHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 站点配置类
 * Created by jingz on 2017/2/8.
 */
@Service("siteService")
public class SiteServiceImpl implements SiteService {

    private MenuHandler menuHandler; // 菜单处理类

    @Autowired
    private SiteMenuMapper menuMapper;


    @Override
    public List<VMenu> getMenu() {
        // 获取所有菜单
        List<SiteMenu> allMenus = menuMapper.selectAll();
        // 获取顶级菜单
        List<SiteMenu> topMenus = menuMapper.selectTopMenu();
        // 初始化菜单处理类
        this.menuHandler = new MenuHandler(allMenus, topMenus);
        // 递归生成菜单对象
        return menuHandler.toMenuList();
    }
}
