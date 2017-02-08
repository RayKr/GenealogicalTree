package com.swroom.genealogy.service;

import com.swroom.genealogy.model.vo.VMenu;
import com.swroom.genealogy.model.vo.VSite;

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

    /**
     * 获取站点配置信息
     * @return 站点信息
     */
    VSite getSiteConfig();
}
