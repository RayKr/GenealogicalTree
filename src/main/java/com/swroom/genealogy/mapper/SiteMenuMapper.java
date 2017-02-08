package com.swroom.genealogy.mapper;

import com.swroom.genealogy.model.po.SiteMenu;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("menuMapper")
public interface SiteMenuMapper extends Mapper<SiteMenu> {

    /**
     * 获取所有一级菜单（无parent_menu_id）
     * @return
     */
    List<SiteMenu> selectTopMenu();
}