package 组合使用;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class 最好用的字节流 {
    public static void main(String[] args) throws Exception {
        //模式设置为读写及时刷新（rwd）
        var rd = new RandomAccessFile(new File("hello5.txt"), "rwd");
        //随机文件流
    }
}
