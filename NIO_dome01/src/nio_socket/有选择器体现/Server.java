package nio_socket.有选择器体现;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        var serverSocket = ServerSocketChannel.open();
        //非阻塞模式
        serverSocket.configureBlocking(false);
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 8875), 10);

        //创建一个选择器
        Selector selector = Selector.open();
        //注册连接事件
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        while ( true ) {
            var sc = serverSocket.accept();
            if ( null == sc ) {
                System.err.println("没有连接");
                var count = selector.select(); //阻塞等待并发
                System.out.println(count);
                //这样就能体现非阻塞接收消息了。我还可以通过某些算法来调整休眠时间

                Thread.sleep(1000);
            } else {
                System.out.println( sc.getRemoteAddress() + "连接到服务器啦!" + selector.select());
            }
        }
    }
}
