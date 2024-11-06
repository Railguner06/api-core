package org.example.socket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import org.example.session.defaults.DefaultGatewaySessionFactory;
import org.example.socket.handlers.GatewayServerHandler;

/**
 * 会话管道初始化类
 */
public class GatewayChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final DefaultGatewaySessionFactory gatewaySessionFactory;

    public GatewayChannelInitializer(DefaultGatewaySessionFactory gatewaySessionFactory) {
        this.gatewaySessionFactory = gatewaySessionFactory;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline line = channel.pipeline();
        line.addLast(new HttpRequestDecoder());
        line.addLast(new HttpResponseEncoder());
        line.addLast(new HttpObjectAggregator(1024 * 1024));
        line.addLast(new GatewayServerHandler(gatewaySessionFactory));
    }

}

