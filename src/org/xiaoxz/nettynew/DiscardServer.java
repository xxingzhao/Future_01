package org.xiaoxz.nettynew;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @Author : xiaoxz
 * @Date: Created in 2017/10/18
 * @Modified by :
 **/
public class DiscardServer {

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception{
        EventLoopGroup bossGroup = null;
        EventLoopGroup workGroup = null;

        try {
            bossGroup = new NioEventLoopGroup();
            workGroup = new NioEventLoopGroup();

            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
            .option(ChannelOption.SO_BACKLOG, 128)
            .option(ChannelOption.SO_KEEPALIVE, true);


            ChannelFuture channelFuture = b.bind(this.port).sync();

            channelFuture.channel().closeFuture().sync();
        } finally {

            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }
    public static void main(String[] args) throws Exception {
        int port =8765;
        try{
            if(args.length>0) {
                port = Integer.parseInt(args[0]);
            }else{
                port = 8765;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            port = 8765;
        }
        new DiscardServer(port).run();
    }
}
