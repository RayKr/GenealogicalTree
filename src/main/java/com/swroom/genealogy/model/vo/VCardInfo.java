package com.swroom.genealogy.model.vo;

/**
 * 个人卡片信息所需字段
 * Created by jingz on 2017/2/9.
 */
public class VCardInfo {

    private int pid; // id
    private String name; // 名
    private String styleName; // 字
    private String selfName; // 号
    private String portraitUrl; // 头像图片地址

    public VCardInfo() {
    }

    public VCardInfo(int pid, String name, String styleName, String selfName, String portraitUrl) {
        this.pid = pid;
        this.name = name;
        this.styleName = styleName;
        this.selfName = selfName;
        this.portraitUrl = portraitUrl;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    @Override
    public String toString() {
        return "VCardInfo{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", styleName='" + styleName + '\'' +
                ", selfName='" + selfName + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                '}';
    }
}
