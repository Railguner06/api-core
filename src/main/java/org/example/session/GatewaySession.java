package org.example.session;

import org.example.bind.IGenericReference;

import java.util.Map;

/**
 * 用户处理网关HTTP请求
 */
public interface GatewaySession {

    Object get(String methodName, Map<String, Object> params);

    Object post(String methodName, Map<String, Object> params);

    IGenericReference getMapper();

    Configuration getConfiguration();
}
