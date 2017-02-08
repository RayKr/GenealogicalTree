package com.swroom.genealogy.model.po;

import javax.persistence.*;

@Table(name = "site_menu")
public class SiteMenu {
    /**
     * 菜单ID
     */
    @Id
    @Column(name = "menu_id")
    private Integer menuId;

    /**
     * 父菜单ID
     */
    @Column(name = "parent_menu_id")
    private Integer parentMenuId;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单链接
     */
    @Column(name = "menu_url")
    private String menuUrl;

    @Column(name = "menu_sort")
    private Integer menuSort;

    @Column(name = "menu_tag")
    private String menuTag;

    /**
     * 获取菜单ID
     *
     * @return menu_id - 菜单ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取父菜单ID
     *
     * @return parent_menu_id - 父菜单ID
     */
    public Integer getParentMenuId() {
        return parentMenuId;
    }

    /**
     * 设置父菜单ID
     *
     * @param parentMenuId 父菜单ID
     */
    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取菜单链接
     *
     * @return menu_url - 菜单链接
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单链接
     *
     * @param menuUrl 菜单链接
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * @return menu_sort
     */
    public Integer getMenuSort() {
        return menuSort;
    }

    /**
     * @param menuSort
     */
    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    /**
     * @return menu_tag
     */
    public String getMenuTag() {
        return menuTag;
    }

    /**
     * @param menuTag
     */
    public void setMenuTag(String menuTag) {
        this.menuTag = menuTag == null ? null : menuTag.trim();
    }
}