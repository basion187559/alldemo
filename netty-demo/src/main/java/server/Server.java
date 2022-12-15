package server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-15 11:36
 */
public class Server {

    public static void main(String[] args) throws Exception{
        //Configure the server
        //创建两个EventLoopGroup对象
        //创建boss线程组 用于服务端接受客户端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //创建worker线程组 用于进行 socketChannel的数据读写
        EventLoopGroup wokerGroup = new NioEventLoopGroup();

        try {
            //创建ServerBootStrap对象
            ServerBootstrap bootstrap = new ServerBootstrap();
            //设置使用的EventLoopGroup
            bootstrap.group(bossGroup,wokerGroup)
                    //设置要被实例化的为 NioServerSocketChannel 类
                    .channel(NioServerSocketChannel.class)
                    // 设置 NioServerSocketChannel 的处理器
                    .handler(new LoggingHandler(LogLevel.INFO))
                    // 设置连入服务端的 Client 的 SocketChannel 的处理器
                    .childHandler(new ServerInitializer());
            ChannelFuture f = bootstrap.bind(8888);
            // 监听服务端关闭，并阻塞等待
            f.channel().closeFuture().sync();
        }finally {
            // 优雅关闭两个 EventLoopGroup 对象
            bossGroup.shutdownGracefully();
            wokerGroup.shutdownGracefully();
        }
    }
}
