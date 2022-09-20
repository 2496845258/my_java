package priv.luzhao.mail.client;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class MailClient {
    private MailClient() {
    }
    private static MailClient mailClient;
    private static Object object = new Object();
    public static MailClient getInstance() {
        if ( null == mailClient ) {
            synchronized ( object ) {
                if ( null == mailClient ) {
                    mailClient = new MailClient();
                }
            }
        }
        return mailClient;
    }

    public List<String> send(Mail mail) {

        if ( null == mail.getMsgs() && mail.getMsgs().size() < 1 ) {
            System.err.println("没有消息，无法发送");
            return null;
        }

        try {
            var socket = new Socket(mail.getServer(), mail.getPort());
            var in = socket.getInputStream();
            var out = socket.getOutputStream();

            var list = outin(in, out, mail);
            socket.close();
            return list;

        } catch (Exception e) {
            System.err.println("无法获取连接");
            return null;
        }
    }

    private List<String> outin(InputStream in, OutputStream out, Mail mail) {
        var list = new ArrayList<String>();
        list.add( getMsg(in) );

        sendMsg("helo test", out);
        fenxi(getMsg(in), "服务器无法连通", list);

        sendMsg("auth login", out);
        fenxi(getMsg(in), "无法登录", list);

        sendMsg(Base64.getEncoder().encodeToString(mail.getAccount().getBytes()), out);
        if ( false == fenxi(getMsg(in), "账号错误", list) ) {
            return list;
        }

        sendMsg(Base64.getEncoder().encodeToString(mail.getPassword().getBytes()), out);
        if ( false == fenxi(getMsg(in), "密码错误", list) ) {
            return list;
        }

        sendMsg("mail from:<" + mail.getAccount() + ">", out);
        fenxi(getMsg(in), "设置邮件发送人出错", list);

        sendMsg("rcpt to:<" + mail.getReceive() + ">", out);
        fenxi(getMsg(in), "设置邮件收件人出错", list);

        sendMsg("data", out);
        fenxi(getMsg(in), "服务器不能进行通信", list);

        sendMsg("from:" + mail.getAccount(), out);
        sendMsg("to:" + mail.getReceive(), out);
        sendMsg("subject:" + mail.getTitle(), out);

        if ( mail.getMainType() == MailType.HTML ) {
            sendMsg("Content-Type: text/html; charset=\"UTF-8\"" + "\r\n", out);
        }
        //消息体
        if ( null == mail.getMsgs() ) {
//            sendMsg("hello world", out);
            return null;
        } else {
            for ( var i : mail.getMsgs() ) {
                sendMsg(i, out);
            }
        }
        sendMsg(".", out);
        fenxi(getMsg(in), "服务器无法完成解析", list);
        return list;
    }

    private boolean fenxi(String msg, String err, List<String> list) {
        list.add(msg);
        if ( Integer.parseInt(msg.substring(0,3)) >= 500 ) {
            System.err.println(err);
            return false;
        }
        return true;
    }

    private void sendMsg(String msg, OutputStream out) {
        try {
            msg += "\r\n";
            out.write( msg.getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (IOException e) {
            System.err.println("发送失败");
            e.printStackTrace();
        }
    }

    private String getMsg(InputStream in) {
        var len = 0;
        var bys = new byte[1024];
        try {
            var msg = "";
            while ( -1 != (len = in.read(bys))  ) {
                msg = new String(bys, 0, len, StandardCharsets.UTF_8);
                if ( len < 1024 ) {
                    break;
                }
            }
            return msg;
        } catch (IOException e) {
            System.err.println("服务器无响应");
            return null;
        }
    }

}
