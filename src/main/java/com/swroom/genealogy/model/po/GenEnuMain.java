package com.swroom.genealogy.model.po;

import javax.persistence.*;

@Table(name = "gen_enu_main")
public class GenEnuMain {
    @Column(name = "enum_type")
    private String enumType;

    @Column(name = "enum_title")
    private String enumTitle;

    /**
     * @return enum_type
     */
    public String getEnumType() {
        return enumType;
    }

    /**
     * @param enumType
     */
    public void setEnumType(String enumType) {
        this.enumType = enumType == null ? null : enumType.trim();
    }

    /**
     * @return enum_title
     */
    public String getEnumTitle() {
        return enumTitle;
    }

    /**
     * @param enumTitle
     */
    public void setEnumTitle(String enumTitle) {
        this.enumTitle = enumTitle == null ? null : enumTitle.trim();
    }
}