package com.swroom.genealogy.service;

/**
 * 枚举取值接口
 * Created by jingz on 2017/2/6.
 */
public interface EnumService {

    /**
     * 通过枚举类型，枚举值获取枚举名称
     * @param type enum_type
     * @param value enum_value
     * @return enum_name
     */
    String getEnu(String type,String value);

    /**
     * 刷新枚举
     */
    void reload();
}
