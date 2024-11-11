package org.example.executor;

import org.example.executor.result.GatewayResult;
import org.example.mapping.HttpStatement;

import java.util.Map;

public interface Executor {
    GatewayResult exec(HttpStatement httpStatement, Map<String,Object> params)throws Exception;
}
