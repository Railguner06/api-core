package org.example.core.datasource.unpooled;

import org.example.core.datasource.DataSource;
import org.example.core.session.Configuration;
import org.example.core.datasource.DataSourceFactory;
import org.example.core.datasource.DataSourceType;

/**
 * 无池化连接池工厂
 */
public class UnpooledDataSourceFactory implements DataSourceFactory {
    protected UnpooledDataSource dataSource;

    public UnpooledDataSourceFactory() {
        this.dataSource = new UnpooledDataSource();
    }

    @Override
    public void setProperties(Configuration configuration, String uri) {
        this.dataSource.setConfiguration(configuration);
        this.dataSource.setDataSourceType(DataSourceType.Dubbo);
        this.dataSource.setHttpStatement(configuration.getHttpStatement(uri));
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

}
