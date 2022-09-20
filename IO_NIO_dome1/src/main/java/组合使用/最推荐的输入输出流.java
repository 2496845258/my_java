package 组合使用;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class 最推荐的输入输出流 {
    public static void main(String[] args) throws Exception {
        var url = "./IO_NIO_dome1/src/main/resources/hello5.txt"; //win不区分大小写文件

        //1、输出流，fileoutSteam中的true表示追加，false，表示不会自动刷新缓冲区，最后指定编码
        var out = new PrintWriter(new FileOutputStream(url, true), false, StandardCharsets.UTF_8);
//        var out1 = new PrintWriter(url,"UTF-8"); //这个方法构造只能覆盖，虽然方便，但是可定制太小了
        out.write("\n追加1");
        out.flush();    //手动刷新输入缓存到文件中，不用关闭文件才生效


        //2、输出流，用Scanner，Scanner本身不是做输入输出流的，只是它能扫描某些流，所以用在输入方面很好
        var in = new Scanner(new FileInputStream(url), StandardCharsets.UTF_8);     //指定源，和编码
        while ( in.hasNextLine() ) {
            System.out.println(in.nextLine());
        }

        //在网络io方面是NIO做得更好，所以你需要通信服务器的时候就用NIO
    }
}
