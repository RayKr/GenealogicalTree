package com.swroom.genealogy.common.enums;

/**
 * 是否枚举
 * Created by jingz on 2017/2/4.
 */
public enum Boolean {

    YES(1), NO(0);

    private int nCode;

    Boolean(int nCode) {
        this.nCode = nCode;
    }

    @Override
    public String toString() {
        return String.valueOf(this.nCode);
    }

}
