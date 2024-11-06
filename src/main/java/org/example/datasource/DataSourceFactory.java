package org.example.datasource;

import org.example.session.Configuration;

/**
 * 数据源工厂
 */
public interface DataSourceFactory {
    void setProperties(Configuration configuration, String uri);

    DataSource getDataSource();
}
