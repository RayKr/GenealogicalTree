package com.swroom.genealogy.service.common;

import com.swroom.genealogy.model.po.SiteMenu;
import com.swroom.genealogy.model.vo.VMenu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by jingz on 2017/2/8.
 */
public class MenuHandler {

    private List<SiteMenu> allMenus; // 全部菜单
    private List<SiteMenu> topMenus; // 顶级菜单
    private List<VMenu> nodes;  // 返回的菜单节点列表

    public MenuHandler(List<SiteMenu> allMenus, List<SiteMenu> topMenus) {
        this.allMenus = allMenus;
        this.topMenus = topMenus;
    }

    /**
     * 对外开放的封装方法
     * @return
     */
    public List<VMenu> toMenuList() {
        this.nodes = new ArrayList<>();
        return this.toMenuModels(topMenus, nodes);
    }

    /**
     * 递归方法获取节点菜单
     * @param appMenus
     * @param nodes
     * @return
     */
    private List<VMenu> toMenuModels(List<SiteMenu> appMenus, List<VMenu> nodes) {
        for (SiteMenu menu : appMenus) {
            // 判断是否有子菜单
            List<SiteMenu> children = this.getChildren(menu);
            if (!children.isEmpty()) {
                nodes.add(convert(menu));
                // 如果有子菜单，则需要递归
                this.toMenuModels(children, nodes.get(nodes.size()-1).getSubmenu());
            } else {
                // 如果没有子菜单，则将本菜单加入到list中
                nodes.add(convert(menu));
            }
        }
        return nodes;
    }

    /**
     * 获取子菜单
     * @param menu 当前菜单
     * @return 子菜单list
     */
    private List<SiteMenu> getChildren(SiteMenu menu) {

        List<SiteMenu> children = new ArrayList<>();
        int mid = menu.getMenuId();

        for (SiteMenu child : allMenus) {
            if (child.getParentMenuId() != null && mid == child.getParentMenuId()) {
                children.add(child);
            }
        }

        return children;
    }

    /**
     * 将SiteMenu字段封装到VMenu
     * @param menu
     * @return
     */
    private VMenu convert(SiteMenu menu) {
        return new VMenu(menu.getMenuId(), menu.getMenuName(), menu.getMenuUrl(), menu.getMenuTag(), new ArrayList<VMenu>());
    }
}
