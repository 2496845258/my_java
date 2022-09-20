package 邮件客户端;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Mail {
    public static void main(String[] args) {
        var mail = new Mail();
        mail.setUsername("luzhaoya@qq.com");
        mail.setPassword("zvdcojliopafebhd");
        mail.setReceive("2496845258@qq.com");
        mail.setTitle("我是标题");
        mail.setText("<!DOCTYPE html>\n" +
                "<html lang=\"ch\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>你好</h2>\n" +
                "</body>\n" +
                "</html>");

        mail.send();
    }
    private String mailserver = "smtp.qq.com";
    private int port = 587;
    private String username;
    private String password;
    private String receive;

    private String title = "null";

    private String text = "";

    private Socket socket;

    public Mail() {
    }

    public Mail(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private void send() {
        try {
            socket = new Socket(mailserver, port);
            var in = socket.getInputStream();
            var put = socket.getOutputStream();

            var list = new ArrayList<String>();

            sendMsg("helo test", put);
            Test.input(in);
            sendMsg("auth login", put);
            Test.input(in);
            sendMsg(Base64.getEncoder().encodeToString(username.getBytes()), put);
            Test.input(in);
            sendMsg(Base64.getEncoder().encodeToString(password.getBytes()), put);
            Test.input(in);
            sendMsg("mail from:<" + username + ">", put);
            Test.input(in);
            sendMsg("rcpt to:<" + receive + ">", put);
            Test.input(in);
            sendMsg("data", put);
            Test.input(in);

            sendMsg("from:" + username, put);
            sendMsg("to:" + receive, put);
            sendMsg("subject:" + title, put);
            //表明传输过去的文本类型
            sendMsg("Content-Type: text/html; charset=\"UTF-8\"" + "\r\n", put);

            sendMsg(text, put);

            sendMsg(".", put);
            Test.input(in);


            socket.shutdownOutput();
            socket.close();
        } catch (IOException e) {
            System.err.println("无法获取连接");
            e.printStackTrace();
        }
    }

    private void sendMsg(String msg, OutputStream out) {
        try {
            msg += "\r\n";
            out.write(msg.getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (IOException e) {
            System.err.println("发生错误");
            e.printStackTrace();
        }
    }


    public String getMailserver() {
        return mailserver;
    }

    public void setMailserver(String mailserver) {
        this.mailserver = mailserver;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }
}
