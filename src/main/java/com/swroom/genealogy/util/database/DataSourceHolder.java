package com.swroom.genealogy.util.database;

/**
 * 数据源操作
 * @author Zonglei Jing
 * @date 2017/11/2
 */
public class DataSourceHolder {
    /**
     * 线程本地环境
     */
    private static final ThreadLocal<String> DATA_SOURCES = new ThreadLocal<>();

    /**
     * 设置数据源
     * @param customerType
     */
    public static void setDataSource(String customerType) {
        DATA_SOURCES.set(customerType);
    }
    /**
     * 获取数据源
     */
    public static String getDataSource() {
        return DATA_SOURCES.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDataSource() {
        DATA_SOURCES.remove();
    }
}
