package 字符流.将字节流转换为字符流;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class 基础文件字节io流 {
    public static void main(String[] args) throws Exception {
        var url = "IO_NIO_dome1/src/main/resources/hello2.txt";

        //1、输出流，Writer是字符输出的抽象基类，"输出流，没有文件会创建文件"
        var outWriter = new OutputStreamWriter( new FileOutputStream(url), "UTF-8");
        //下面这种方法也可以，保证了不会写错编码，但也牺牲了灵活性
//        var outWriter = new OutputStreamWriter( new FileOutputStream(url), StandardCharsets.UTF_8);
        var msg = "Hello\nWorld\n陆昭";
        outWriter.write(msg);
        outWriter.close();  //不关闭，以为你没写完，关闭了就不能再write了

        //2、输入流，Reader为字符输入流的抽象基类
        var inReader = new InputStreamReader( new FileInputStream(url), "UTF-8" );
        var chs = new char[1024];   //我们假定文本字符长度小于1024
        var i = inReader.read(chs);
        System.out.println( new String( chs, 0, i));
    }
}
