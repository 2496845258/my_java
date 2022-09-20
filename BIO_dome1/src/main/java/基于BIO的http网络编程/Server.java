package 基于BIO的http网络编程;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        //http://127.0.0.1:8891/
        var server = new ServerSocket(8891);

        //等待tcp连接
        var socket = server.accept(); //新浏览器访问，会发送连接。（发现即使是点击刷新按钮，也不是新连接）

        //实现http长连接。（通过返回的html中携带着一个ajax请求，来模拟一个网页中的多次http请求）
        //实验结果，发现同一个tcp连接，可以发送多个html请求
        //第一次访问就给你一个首页，如果不是第一次访问就返回给你数字
        var t = 0;
        var index = 0;
        while ( true ) {
            var in = socket.getInputStream();
            var by = new byte[1024];
            var len = -1;
            // tcp长连接会让同一个客户端一直使用这个tcp
            // in.read() 方法是个阻塞方法，如果无数据可读，就会阻塞直到有数据可读。
            // 使客户端已经关闭连接了，read()也继续在这阻塞。这是很奇怪的
            while ( -1 != (len = in.read( by)) ) {
                System.out.print( new String(by, 0, len));
                if ( len < 1024 ) {
                    break;
                }
            }
            if ( -1 == len ) {
                //-1 表示没有请求报文，没有报文响应什么。真的是
                Thread.sleep(100);
                if ( 100 == t++ ) {
                    //10秒没有消息，自动断开连接
                    System.err.println("服务器长时间未收到请求!主动断开连接");
                    socket.close();
                    break;
                }
                continue;
            }

            var out = socket.getOutputStream();
            if ( index++ == 0 ) {
                var url = URLDecoder.decode(Server.class.getResource("index.html").toString().substring(6), StandardCharsets.UTF_8);
                var rd = new RandomAccessFile(url, "rwd");
                //响应报文
                var str = "HTTP/1.1 200 OK\r\n";
                str += "Content-Type: text/html\r\n";
                //如果不设定长度，客户端不知道什么时候停止接收（除非手动停止输入流）
                str += "Content-length: " + (rd.length()) + "\r\n";
                str += "Connection: keep-alive\r\n";
                //允许跨域，跨域地址 所有地址
                str += "Access-Control-Allow-Origin: *\r\n";
                str += "Access-Control-Allow-Methods: GET,POST\r\n";
                str += "\r\n";
                out.write(str.getBytes());

                //输出文件
                var bbs = new byte[1024];
                var t2 = 0;
                while ( -1 != (t2 = rd.read(bbs)) ) {
                    out.write(Arrays.copyOfRange(bbs, 0, t2));
                    if ( t2 < bbs.length ) {
                        break;
                    }
                }
                out.flush();
            } else {
                var msg = "hello: " + index;

                var str = "HTTP/1.1 200 OK\r\n";
                str += "Content-Type: text/plain\r\n";
                str += "Content-length: " + (msg.length()) + "\r\n";
                str += "Connection: keep-alive\r\n";
                str += "Access-Control-Allow-Origin: *\r\n";
                str += "Access-Control-Allow-Methods: GET,POST\r\n";
                str += "\r\n";
                str += msg;
                //输出字符串
                out.write(str.getBytes());
                out.flush();
            }
        }
    }
}
