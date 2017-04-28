package com.shhxzq.fin.ehelper.biz.util;

import com.shhxzq.fin.ehelper.model.constants.DataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源
 *
 * @author kangyonggan
 * @since 4/28/17
 */
public class MultiDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal();

    public static void setDataSource(DataSource dataSource) {
        dataSourceKey.set(dataSource.name());
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}
