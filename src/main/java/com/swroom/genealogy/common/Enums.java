package com.swroom.genealogy.common;

import com.swroom.genealogy.service.EnumService;

/**
 * Created by jingz on 2017/2/6.
 */
public class Enums {

    private EnumService enu; // Spring Bean
    private static Enums es; // 静态对象

    // setter方法用以实现注入
    public void setEnu(EnumService enu) {
        this.enu = enu;
    }

    /**
     * 初始化方法
     */
    public void init() {
        es = this;
        es.enu = this.enu;
    }

    public static String getEnuName(String type,String value) {
        return es.enu.getEnu(type, value);
    }
}
