package com.swroom.genealogy.service;

import com.swroom.genealogy.model.vo.VMenu;

import java.util.List;

/**
 * 站点接口
 * Created by jingz on 2017/2/8.
 */
public interface SiteService {

    /**
     * 获取菜单列表
     * @return 站点菜单
     */
    List<VMenu> getMenu();

}
