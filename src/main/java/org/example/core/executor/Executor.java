package org.example.core.executor;

import org.example.core.executor.result.SessionResult;
import org.example.core.mapping.HttpStatement;

import java.util.Map;

/**
 * 执行器
 */
public interface Executor {
    SessionResult exec(HttpStatement httpStatement, Map<String,Object> params) throws Exception;
}
