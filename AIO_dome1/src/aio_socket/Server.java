package aio_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws Exception {
        var server = AsynchronousServerSocketChannel.open();
        server.bind(new InetSocketAddress("127.0.0.1", 8892), 10);

        while ( true) {
            var future = server.accept();
            var conn = future.get();

            var buff = ByteBuffer.allocateDirect(1024);
            var len = conn.read(buff);
            var bbs = new byte[len.get()];
            buff.flip();
            buff.get(bbs);
            System.out.println( new String(bbs, 0, len.get(), StandardCharsets.UTF_8));
        }
    }
}
