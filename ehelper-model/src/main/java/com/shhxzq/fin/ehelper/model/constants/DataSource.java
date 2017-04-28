package com.shhxzq.fin.ehelper.model.constants;

/**
 * @author kangyonggan
 * @since 4/28/17
 */
public enum DataSource {
    DEV, UAT;

    public static DataSource getDataSource(String name) {
        for (DataSource dataSource : DataSource.values()) {
            if (dataSource.name().equalsIgnoreCase(name)) {
                return dataSource;
            }
        }

        return DataSource.DEV;
    }
}
