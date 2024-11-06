package org.example.session.defaults;

import org.example.bind.IGenericReference;
import org.example.datasource.Connection;
import org.example.datasource.DataSource;
import org.example.session.Configuration;
import org.example.session.GatewaySession;

/**
 * 默认网关会话实现类
 */
public class DefaultGatewaySession implements GatewaySession {

    private Configuration configuration;
    private String uri;
    private DataSource dataSource;

    public DefaultGatewaySession(Configuration configuration, String uri, DataSource dataSource) {
        this.configuration = configuration;
        this.uri = uri;
        this.dataSource = dataSource;
    }

    @Override
    public Object get(String methodName, Object parameter) {
        Connection connection = dataSource.getConnection();
        return connection.execute(methodName, new String[]{"java.lang.String"}, new String[]{"name"}, new Object[]{parameter});
    }

    @Override
    public IGenericReference getMapper() {
        return configuration.getMapper(uri, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}
