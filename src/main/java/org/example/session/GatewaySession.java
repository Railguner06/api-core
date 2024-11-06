package org.example.session;

import org.example.bind.IGenericReference;

/**
 * 用户处理网关HTTP请求
 */
public interface GatewaySession {

    Object get(String methodName, Object parameter);

    IGenericReference getMapper();

    Configuration getConfiguration();


}