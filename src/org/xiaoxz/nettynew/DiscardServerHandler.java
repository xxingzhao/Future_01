package org.xiaoxz.nettynew;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * @Author : xiaoxz
 * @Date: Created in 2017/10/18
 * @Modified by :
 **/
public class DiscardServerHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       cause.printStackTrace();
       ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf data = (ByteBuf)msg;
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
