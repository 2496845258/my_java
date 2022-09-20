package nio_socket.无选择器体现非阻塞;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        var serverSocket = ServerSocketChannel.open();
        //非阻塞模式
        serverSocket.configureBlocking(false);
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 8877), 10);
        while ( true ) {
            var sc = serverSocket.accept();

            if ( null == sc ) {
                System.err.println("没有连接");
                //sc获取与服务器的连接，如果这时候没有连接，就返回null。说明是非阻塞的，但是这样并不能处理并发
                //我还可以通过某些算法来调整休眠时间
                Thread.sleep(1000);
            } else {
                System.out.println( sc.getRemoteAddress() + "连接到服务器啦" );
            }
        }
    }
}
