package com.swroom.genealogy.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "gen_person_info")
public class GenPersonInfo {
    @Id
    private Integer pid;

    private Date birthday;

    @Column(name = "current_address")
    private String currentAddress;

    private String cellphone;

    private String profession;

    private String position;

    private String introduction;

    private String portrait;

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return current_address
     */
    public String getCurrentAddress() {
        return currentAddress;
    }

    /**
     * @param currentAddress
     */
    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress == null ? null : currentAddress.trim();
    }

    /**
     * @return cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @param cellphone
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    /**
     * @return profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession
     */
    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    /**
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * @return portrait
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * @param portrait
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }
}