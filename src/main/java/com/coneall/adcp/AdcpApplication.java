package com.coneall.adcp;

import com.coneall.adcp.server.NettyConfig;
import com.coneall.adcp.server.NettyServer;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdcpApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AdcpApplication.class, args);
    }

    @Autowired
    private NettyServer nettyServer;
    private int port = 11111;

    @Override
    public void run(String... args) throws Exception {
        ChannelFuture init = nettyServer.init(port);
        //Runtime.getRuntime().addShutdownHook(new Thread(()->nettyServer.close()));
        init.channel().closeFuture().syncUninterruptibly();
    }
}
