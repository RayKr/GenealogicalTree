package com.swroom.genealogy.common.enums;

/**
 * 性别枚举
 * Created by jingz on 2017/2/4.
 */
public enum Sex {

    // 构造函数传参
    MAN(1), WOMAN(0);

    private int nCode;

    Sex(int nCode) {
        this.nCode = nCode;
    }

    @Override
    public String toString() {
        return String.valueOf(this.nCode);
    }
}
