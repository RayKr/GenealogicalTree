package com.swroom.genealogy.model.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单实体类
 * Created by Ray on 2016/7/15.
 */
public class VMenu {

    private int mid;
    private String mname = "";
    private String url = "";
    private String tag = "";
    private List<VMenu> submenu = new ArrayList<>();

    public VMenu() {
    }

    public VMenu(int mid, String mname, String url, String tag, List<VMenu> submenu) {
        this.mid = mid;
        this.mname = mname;
        this.url = url;
        this.tag = tag;
        this.submenu = submenu;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<VMenu> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<VMenu> submenu) {
        this.submenu = submenu;
    }
}
