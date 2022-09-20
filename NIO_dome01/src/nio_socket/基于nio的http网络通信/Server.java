package nio_socket.基于nio的http网络通信;

import utils.MyByteBufferUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        //http://127.0.0.1:8866
        var serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 8866), 10);
        //非阻塞模式
        serverSocket.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        while ( true ) {
            //阻塞等待连接
            selector.select();

            //使用迭代器，迭代请求
            var iterator = selector.selectedKeys().iterator();
            var index = 0;
            while ( iterator.hasNext() ) {
                var selectionKey = iterator.next();
                if ( selectionKey.isAcceptable() ) {
                    //连接事件。为什么用选择器来发现事件之后再获取连接呢？因为这个是非阻塞的
                    var client = serverSocket.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ );   //注册为读事件
                    System.err.println( client.getRemoteAddress().toString().substring(1) + " 连接到服务器 ");
                    //从这里我们能看到，nio，可以说是自带并发处理。即使有人断开了，nio竟然还能继续工作。这就是比bio好
                } else if ( selectionKey.isReadable() ) {
                    //读事件
                    var buff = ByteBuffer.allocateDirect(1024);
                    var clientSocketChannel = (SocketChannel) selectionKey.channel();
                    var len = clientSocketChannel.read(buff);
                    if ( len == -1 ) {
                        //并且还优于bio，客户端断开连接的时候竟然能发现，不会因为read持续阻塞卡死
                        clientSocketChannel.close(); //这样我就能主动断开了
                        //无论是bio，还是nio，基于socket的通信，如果只shutdownOut 不 close() 都会导致这样的问题（双方）
                        System.err.println("客户端已主动断开连接！");
                        iterator.remove();
                        continue;
                    }

                    //从缓冲区中读取数据
                    buff.flip();
                    var bbs = new byte[1000];
                    var tt = -1;
                    while ( 0 != (tt = MyByteBufferUtil.read(buff, bbs)) ) {
                        System.out.print( new String(bbs, 0, tt));
                        if ( tt < bbs.length ) {
                            break;
                        }
                    }
                    var msg = "hello: " + index;

                    var str = "HTTP/1.1 200 OK\r\n";
                    str += "Content-Type: text/plain\r\n";
                    str += "Content-length: " + (msg.length()) + "\r\n";
                    str += "Connection: keep-alive\r\n";
                    str += "Access-Control-Allow-Origin: *\r\n";
                    str += "Access-Control-Allow-Methods: GET,POST\r\n";
                    str += "\r\n";
                    str += msg;

                    buff.clear();
                    buff.position(0);
                    buff.limit(1024);
                    buff.put(str.getBytes());
                    buff.flip();

                    clientSocketChannel.write(buff);

                }
                iterator.remove();
            }
        }
    }
}
