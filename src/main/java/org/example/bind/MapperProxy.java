package org.example.bind;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.example.session.GatewaySession;

import java.lang.reflect.Method;

/**
 * 映射代理调用
 */
public class MapperProxy implements MethodInterceptor {

    private GatewaySession gatewaySession;
    private final String uri;

    public MapperProxy(GatewaySession gatewaySession, String uri) {
        this.gatewaySession = gatewaySession;
        this.uri = uri;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        MapperMethod linkMethod = new MapperMethod(uri, method, gatewaySession.getConfiguration());
        return linkMethod.execute(gatewaySession, args);
    }

}
