package org.example.executor;

import org.example.executor.result.SessionResult;
import org.example.mapping.HttpStatement;

import java.util.Map;

/**
 * 执行器
 */
public interface Executor {
    SessionResult exec(HttpStatement httpStatement, Map<String,Object> params) throws Exception;
}
