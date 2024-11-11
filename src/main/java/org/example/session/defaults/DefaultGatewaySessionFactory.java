package org.example.session.defaults;

import org.example.datasource.DataSource;
import org.example.datasource.DataSourceFactory;
import org.example.datasource.unpooled.UnpooledDataSourceFactory;
import org.example.executor.Executor;
import org.example.session.Configuration;
import org.example.session.GatewaySession;
import org.example.session.GatewaySessionFactory;

/**
 * 默认网关会话工厂
 */
public class DefaultGatewaySessionFactory implements GatewaySessionFactory {

    private final Configuration configuration;

    public DefaultGatewaySessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public GatewaySession openSession(String uri) {
        // 获取数据源连接信息：这里把 Dubbo、HTTP 抽象为一种连接资源
        DataSourceFactory dataSourceFactory = new UnpooledDataSourceFactory();
        dataSourceFactory.setProperties(configuration, uri);
        DataSource dataSource = dataSourceFactory.getDataSource();
        // 创建执行器
        Executor executor = configuration.newExecutor(dataSource.getConnection());
        // 创建会话：DefaultGatewaySession
        return new DefaultGatewaySession(configuration, uri, executor);
    }

}

