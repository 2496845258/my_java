package 字节流.以字节的角度来看文件;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 字节读入的基类 {
    public static void main(String[] args) throws Exception {

        var url = "./IO_NIO_dome1/src/main/resources/hello.txt";

        //输入流
        //字节读取的基类 InputStream, 基类是抽象类，其中的默认实现也没办法使用，我们需要他的子类
        var in1 = new FileInputStream(url); //有另一个构造方法，传的是File对象

        //未知字节长度
        var ch = 0;
        var arrs = new ArrayList<Byte>();
        while ( (ch = in1.read() ) != -1 ) {
            var b = (byte) ch;
            arrs.add( b );
        }
        //释放资源
        in1.close();

        //将字符集合转数组进行操作
        var b2 = new byte[arrs.size()];
        for ( var i = 0; i < arrs.size(); i++ ) {
            b2[i] = arrs.get(i);
        }

        //可以操作了，但是你觉得合适吗？一个文件字符串得多长，能理解了吧，所有一定是分段读取
        System.out.println(new String(b2, StandardCharsets.UTF_8));

        //方法2
        //输出流，基类是OutputStream
        var out1 = new FileOutputStream(url);

        //编码并转成字节
        var arrbs = "hello, 123, 你好呀\n你好".getBytes(StandardCharsets.UTF_8);
        out1.write(arrbs);



        /*
        *
            var c = (char)ch;
            byte[] b = new byte[2];
            b[0] = (byte) ((c & 0XFF00 ) >> 8 );
            b[1] = (byte) (c & 0XFF);
        * */

    }
}
