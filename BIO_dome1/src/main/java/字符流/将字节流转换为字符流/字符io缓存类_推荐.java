package 字符流.将字节流转换为字符流;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class 字符io缓存类_推荐 {
    public static void main(String[] args) throws Exception {
        var url = "IO_NIO_dome1/src/main/resources/hello3.txt";

        //输入流对象
        var pw = new PrintWriter(url, "UTF-8");

        pw.write("hello \n陆");  //这个是写入
        pw.flush(); //刷新流，不用关闭文件，就能使得流中的内容生效

        pw.print("hello");          //这个也是写入
        pw.flush();

        pw.close();                 //关闭资源
    }
}
