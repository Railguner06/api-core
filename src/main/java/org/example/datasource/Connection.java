package org.example.datasource;

/**
 * 连接接口
 */
public interface Connection {
    Object execute(String method,String[] parameterTypes,String[] parameterNames,Object[] args);
}
