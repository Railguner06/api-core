package org.example.session;

import org.example.bind.IGenericReference;

/**
 * 用户处理网关HTTP请求
 */
public interface GatewaySession {

    Object get(String uri, Object parameter);

    IGenericReference getMapper(String uri);

    Configuration getConfiguration();

}