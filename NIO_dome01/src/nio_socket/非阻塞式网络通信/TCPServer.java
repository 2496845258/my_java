package nio_socket.非阻塞式网络通信;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;

public class TCPServer {
    public static void main(String[] args) {
        try {
            //获取一个tcp网络通道
            var server = ServerSocketChannel.open();
            //切换为非阻塞式
            server.configureBlocking(false);

            //绑定端口8899，且最大连接数量为10
            server.bind(new InetSocketAddress(8899), 10);

            //获取一个选择器
            var selector = Selector.open();
            //在网络通道中注册选择器，并且监听（接收）事件
            server.register( selector, SelectionKey.OP_ACCEPT);

            while ( true ) {
                var count = selector.select();
                if ( count > 0 ) {
                    //通过选择器中获取连接（因为一个选择器能被多个通道注册）
                    var i = selector.selectedKeys().iterator();
//                    SocketChannel clientread = null;
                    while ( i.hasNext() ) {
                        var t = i.next();
                        //是这个事件吗
                        if ( t.isAcceptable() ) {
                            //是注册事件吗
                            //有连接吗
                            var client = server.accept();
                            //改为非阻塞
                            client.configureBlocking(false);
                            //将改客户端的连接注册到选择器，并添加读事件
                            client.register( selector, SelectionKey.OP_READ );
                            System.out.println( client.getRemoteAddress().toString().substring(1) + " 连接到服务器 " + new InetSocketAddress(8899));
                        } else if ( t.isReadable() ) {
                            //是读事件吗
                            var buff = ByteBuffer.allocateDirect(1024);
                            //获取通道
                            var clientread = (SocketChannel) t.channel();

                            var len = clientread.read(buff);
                            if ( -1 != len ) {
                                var bss = new byte[len];
                                buff.limit(buff.position());
                                buff.position(0);

                                buff.get(bss);
                                System.out.print( new String(bss,  0, bss.length, StandardCharsets.UTF_8));

                                //准备响应的协议和内容
                                var http = "HTTP/1.1 200 OK\r\n";
                                http += "Content-Type: text/plain; charset=utf-8\r\n";
                                http += "Content-length: " + "hello".length() + "\r\n";
                                http += "Connection: keep-alive\r\n";
                                http += "\r\n" + "hello";

                                //复用缓冲区
                                buff.clear();
                                buff.put(http.getBytes(StandardCharsets.UTF_8));
                                buff.flip();

                                //将缓冲区中的内容输入到通道之中
                                clientread.write(buff);
                                //表示我已经结束了输入
//                                clientread.shutdownOutput();
                                //关闭通道。通道是可以复用的，但是客户端只发一次请求，并等待回复。
//                                clientread.close();
                            } else {
//                                buff.clear();
//                                clientread.;
//                                var le2 = clientread.read(buff);
                                System.out.println("-------");
                            }
                        }
                        //默认我已将处理好了，所有就移除
                        i.remove();
                    }
                    System.err.println(666);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
