package nio_socket.本地长连接通信;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            var socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
            socketChannel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

//            var in = new Scanner(System.in);
//            var msg = "hello";
//            while ( true ) {
//                msg = in.next();
//                buffer.put(msg.getBytes());
//                buffer.flip();
//                socketChannel.write(buffer);
//                buffer.clear();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}