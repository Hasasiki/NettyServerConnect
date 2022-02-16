package com.coneall.adcp.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class NettyServer {
    private EventLoopGroup boss = new NioEventLoopGroup();
    private EventLoopGroup worker = new NioEventLoopGroup();
    private Channel channel;

    @Autowired
    private MyServerChannelInitializer initializer;

    public ChannelFuture init(int port){
        ChannelFuture f = null;
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(initializer);
            f =  bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
            channel = f.channel();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }finally {
            channel.close();
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
        return f;
    }
}
