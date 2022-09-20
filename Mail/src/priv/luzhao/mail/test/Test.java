package priv.luzhao.mail.test;

import priv.luzhao.mail.client.Mail;
import priv.luzhao.mail.client.MailClient;
import priv.luzhao.mail.client.MailType;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        //通过账号密码，和收件人创建一个邮件对象
        var mail = new Mail("2496845258@qq.com");

        //邮件标题
        mail.setTitle("这是测试邮件");
        mail.setMainType(MailType.HTML);

        var url = URLDecoder.decode( Test.class.getResource("a.html").toString().substring(6), StandardCharsets.UTF_8);
        mail.setHTML(url);
//        mail.setMsg("你好");

        //发送邮件
        MailClient.getInstance().send(mail);
    }
}
