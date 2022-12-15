package server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-15 11:45
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();
    private static final ServerHandler SERVER_HANDLER = new ServerHandler();
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeLine = ch.pipeline();
        // 添加帧限定符来防止粘包现象
        pipeLine.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        //解码和编码,应和客户端一致
        pipeLine.addLast(DECODER);
        pipeLine.addLast(ENCODER);
        //业务逻辑实现类
        pipeLine.addLast(SERVER_HANDLER);
    }
}
