package priv.luzhao.mail.client;

import priv.luzhao.mail.test.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Mail {
    private String server = "smtp.qq.com";
    private int port = 587;
    private String account;
    private String password;

    //接收端
    private String receive;
    //标题
    private String title = "";
    //邮件类型
    private MailType mailType = MailType.TEXT;

    //正文
    private List<String> msgs;

    public Mail() {
    }

    public Mail(String account, String password, String receive) {
        this.account = account;
        this.password = password;
        this.receive = receive;
    }

    public Mail(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public void setMsg(String msg) {
        this.msgs = new ArrayList<String>();
        this.msgs.add(msg);
    }

    public void setHTML(String path) {
        try {
            var url = URLDecoder.decode(this.getClass().getClassLoader().getResource("priv/luzhao/mail/test/a.html").toString().substring(6), StandardCharsets.UTF_8);
            var rd = new RandomAccessFile(url, "rwd");
            var len = 0;
            var bys = new byte[1024];
            this.msgs = new ArrayList<String>();
            while ( -1 != (len = rd.read(bys)) ) {
                msgs.add(new String(bys, 0, len));
            }
        } catch (IOException e) {
            System.err.println(this.getClass().getClassLoader().getResource(".") + "下找不到" + path);
            e.printStackTrace();
        }
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MailType getMainType() {
        return mailType;
    }

    public void setMainType(MailType mailType) {
        this.mailType = mailType;
    }

    public List<String> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<String> msgs) {
        this.msgs = msgs;
    }


}
