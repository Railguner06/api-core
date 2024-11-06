package org.example.session.defaults;

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
    public GatewaySession openSession() {
        return new DefaultGatewaySession(configuration);
    }

}
