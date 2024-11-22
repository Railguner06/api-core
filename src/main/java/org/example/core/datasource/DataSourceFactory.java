package org.example.core.datasource;

import org.example.core.session.Configuration;

/**
 * 数据源工厂
 */
public interface DataSourceFactory {
    void setProperties(Configuration configuration, String uri);

    DataSource getDataSource();
}
