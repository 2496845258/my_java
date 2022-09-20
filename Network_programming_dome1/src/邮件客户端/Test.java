package 邮件客户端;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        try {
            var socket = new Socket("smtp.qq.com", 587);

            var in = socket.getInputStream();
            var out = socket.getOutputStream();

            input(in);

            output("helo test", out);
            input(in);

            output("auth login", out);
            input(in);

            //账号
            output("bHV6aGFveWFAcXEuY29t", out);
            input(in);

            //授权码
            output("enZkY29qbGlvcGFmZWJoZA==", out);
            input(in);

            output("mail from:<luzhaoya@qq.com>", out);
            input(in);

            output("rcpt to:<2496845258@qq.com>", out);
            input(in);

            output("data", out);
            input(in);

            output("from:luzhaoya@qq.com", out);
            output("to:2496845258@qq.com", out);
//            output("subject:这是个测试邮件\r\n", out);
//            output("hello world", out);
            output("Subject: 你好\r\n" +
                    "Content-Type: text/html; \n" +
                    "<!DOCTYPE html>\n" +
                    "<HTML>\n" +
                    "<BODY>\n" +
                    "SnailWarrior's Photo</BR>\n" +
                    "2022-08-31</BR>\n" +
                    "</BODY>\n" +
                    "</HTML>\n", out);
            output(".", out);

            input(in);

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void input(InputStream in) throws IOException {
        var len = 0;
        var bys = new byte[1024];
        while ( -1 != (len = in.read(bys))  ) {
            System.out.print(new String(bys, 0, len, StandardCharsets.UTF_8));
            if ( len < 1024 ) {
                break;
            }
        }
    }

    public static void output(String msg, OutputStream out) throws IOException {
        msg = msg + "\r\n";
        out.write(msg.getBytes(StandardCharsets.UTF_8));
        out.flush();
    }
}
