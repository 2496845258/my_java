package main;

import com.sun.mail.util.BASE64EncoderStream;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.Scanner;

import static java.util.Base64.*;

public class Test02 {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket();

        //设置连接地址
        SocketAddress socketAddress = new InetSocketAddress("smtp.126.com", 25);

        //打开连接
        socket.connect(socketAddress);
        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

//        socket.getOutputStream().write("HELO: localhost\r\n".getBytes());
        out.write("HELO: localhost\r\n");
        System.out.println(in.nextLine());

        System.out.println(new String(Base64.getEncoder().encode("luzhaoya@126.com".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("TXIMLVJRJQSSLQIF".getBytes())));
    }
}
