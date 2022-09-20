package nio_socket.本地长连接通信;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Arrays;
import java.util.Iterator;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(8888));
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //选择器会阻塞等待事件
            while (selector.select() > 0){
                // selector.select() 有多少个就意味着有多少个并发请求

                System.out.println("==================开启事件处理================");

                //相当于已经把连接存了起来
                var it = selector.selectedKeys().iterator();

                while (it.hasNext()){
                    var selectionKey = it.next();

                    if (selectionKey.isAcceptable()){
                        //连接事件是默认事件（只要有人连接服务器，就是连接事件）
                        System.out.println("连接事件");

                        //获取连接，并打开通道
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        //我把同一个客户端后面来的事件，标记为读事件。通道之中是可以读写并发的
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    }else if (selectionKey.isReadable()){
                        System.out.println("读事件");
                        var socketChannel = (SocketChannel) selectionKey.channel();

                        //如果这里用多线程的话效果会更好。具体的操作交给线程，而我只用管怎么等待外部连接
                        getMsg(socketChannel);
                    }
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getMsg(SocketChannel socketChannel) {

        var n = 200;
        ByteBuffer buffer = ByteBuffer.allocate(n);
        try {
            var mss = new Message();
            var len = -1;
            while ((len = socketChannel.read(buffer)) > 0) {
                buffer.flip();
                //截取数组部分产生新数组
                mss.add( Arrays.copyOfRange(buffer.array(), 0, len) );
                //清除之前的数据（覆盖写入）
                buffer.clear();
                if ( len < buffer.limit() ) {
                    break;
                }
            }
            if (len == -1) {
                throw new RuntimeException("无效数据，客户端未主动关闭通道");
            }

            //开始进行消息处理，使用进程
            //.....
            new Thread(()->{
                if ( 0 != mss.size() ) {
                    var request = Analysis.discoverMsg(mss);
                    if ( null != request ) {
                        if ( request.getMethod().equals("GET") ) {
                            System.out.print(request);
                            //响应请求
                        } else {
                            System.out.println("是post请求");
                        }
                    }
                }
            }).start();

        }catch ( Exception e ) {
            try {
                System.err.println(socketChannel.getRemoteAddress() + ": 主动断开连接。但未关闭通道！");
                socketChannel.close();
                e.printStackTrace();
            } catch (IOException ex) {
                System.err.println("通道已关闭");
                ex.printStackTrace();
            }
        } finally {
            buffer = null;
        }
    }
}