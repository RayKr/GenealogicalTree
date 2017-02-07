package com.swroom.genealogy.common;

import com.swroom.genealogy.service.EnumService;

/**
 * 枚举
 * Created by jingz on 2017/2/6.
 */
public class Enums {

    private static EnumService enu; // Spring Bean

    // setter方法用以实现注入
    public void setEnu(EnumService enu) {
        this.enu = enu;
    }

    public static String getEnuName(String type,String value) {
        return enu.getEnu(type, value);
    }

    public static void reload() {
        enu.reload();
    }
}
