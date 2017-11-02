package com.swroom.genealogy.util.database;

import java.lang.annotation.*;

/**
 * DataSource注解标签，用来切换数据源
 *
 * 使用方法：
 * <p>
 *     @DataSource(name=DataSource.slave2)
 *     public List getProducts(){
 * </p>
 *
 * @Author Zonglei Jing
 * @Date 2017/11/2 17:08
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSource.slave1;

    String slave1 = "dataSource1";

    String slave2 = "dataSource2";


}
