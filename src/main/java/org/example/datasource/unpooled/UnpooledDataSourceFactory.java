package org.example.datasource.unpooled;

import org.example.datasource.DataSource;
import org.example.datasource.DataSourceFactory;
import org.example.datasource.DataSourceType;
import org.example.session.Configuration;

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
