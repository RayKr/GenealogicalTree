package com.swroom.genealogy.util.database;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Zonglei Jing
 * @date 2017/11/2 17:36
 */
public class DataSourceExchange implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        DataSource dataSource = invocation.getMethod().getAnnotation(DataSource.class);
        DataSourceHolder.setDataSource(dataSource.name());
        try {
            invocation.proceed();
        } catch (Exception ex) {
        }
        return null;
    }
}
