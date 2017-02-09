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
    private int sex; // 性别
    private String portraitUrl; // 头像图片地址

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "VCardInfo{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", styleName='" + styleName + '\'' +
                ", selfName='" + selfName + '\'' +
                ", sex=" + sex +
                ", portraitUrl='" + portraitUrl + '\'' +
                '}';
    }

}
