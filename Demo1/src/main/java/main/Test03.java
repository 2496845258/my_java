package main;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.PrintWriter;

import java.io.Reader;

import java.net.Socket;

import java.util.ArrayList;

import java.util.Base64;
import java.util.List;

//import org.apache.commons.codec.binary.Base64;

public class Test03 {
    // from:<~@sohu.com>

    // to:< ~@qq.com >

    public static void main(String[] args) throws Exception{

        //创建socket对象

        Socket sk=new Socket("smtp.126.com",25);

        //创建输出流对象

        OutputStream os=sk.getOutputStream();

        //创建输入对象

        sk.getInputStream();

        BufferedReader br=new BufferedReader(new InputStreamReader(sk.getInputStream()));

        System.out.println(br.readLine());




        os.write("auth login/r/n".getBytes());

        System.out.println(br.readLine());



        os.write("bHV6aGFveWFAMTI2LmNvbQ==/r/n".getBytes());

        System.out.println(br.readLine());

        os.write("VFhJTUxWSlJKUVNTTFFJRg==/r/n".getBytes());

        System.out.println(br.readLine());



        os.write("mail from:<luzhaoya@126.com>/r/n".getBytes());

        System.out.println(br.readLine());



        os.write("rcpt to:< luzhaoya@qq.com >/r/n".getBytes());

        System.out.println(br.readLine());



        os.write("data/r/n".getBytes());

        System.out.println(br.readLine());



        os.write("from:<luzhaoya@126.com>/r/n".getBytes());

        System.out.println(br.readLine());



        os.write("to:< luzhaoya@qq.com >/r/n".getBytes());

        System.out.println(br.readLine());



        os.write("subject:中奖了，快去看看吧>/r/n".getBytes());

        System.out.println(br.readLine());



        os.write("恭喜你获得一万元的大奖，请尽快登陆xxxxxxxxx领取/r/n".getBytes());



        os.write("./r/n".getBytes());

        System.out.println(br.readLine());



        os.write("quit/r/n".getBytes());



        br.close();

        os.close();

        sk.close();

    }
}