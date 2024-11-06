package org.example.session;

/**
 * 网关会话工厂接口
 */
public interface GatewaySessionFactory {

    GatewaySession openSession();

}