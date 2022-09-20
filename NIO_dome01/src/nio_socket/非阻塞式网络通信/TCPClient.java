package nio_socket.非阻塞式网络通信;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        var client = SocketChannel.open();
        client.configureBlocking(false);
        client.connect(new InetSocketAddress("127.0.0.1", 8899));


    }
}
