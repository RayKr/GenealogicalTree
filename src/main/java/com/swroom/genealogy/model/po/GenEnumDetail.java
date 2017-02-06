package com.swroom.genealogy.model.po;

import javax.persistence.*;

@Table(name = "gen_enum_detail")
public class GenEnumDetail {
    @Column(name = "enum_type")
    private String enumType;

    @Column(name = "enum_value")
    private String enumValue;

    @Column(name = "enum_name")
    private String enumName;

    @Column(name = "enum_desc")
    private String enumDesc;

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
     * @return enum_value
     */
    public String getEnumValue() {
        return enumValue;
    }

    /**
     * @param enumValue
     */
    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue == null ? null : enumValue.trim();
    }

    /**
     * @return enum_name
     */
    public String getEnumName() {
        return enumName;
    }

    /**
     * @param enumName
     */
    public void setEnumName(String enumName) {
        this.enumName = enumName == null ? null : enumName.trim();
    }

    /**
     * @return enum_desc
     */
    public String getEnumDesc() {
        return enumDesc;
    }

    /**
     * @param enumDesc
     */
    public void setEnumDesc(String enumDesc) {
        this.enumDesc = enumDesc == null ? null : enumDesc.trim();
    }
}