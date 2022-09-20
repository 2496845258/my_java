package nio_file;

import test.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URLDecoder;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class 对文件进行读写 {
    public static void main(String[] args) throws Exception {
        var url = getPath("resources/b.txt");
        var rdf = new RandomAccessFile(url,"rwd");
        //打开一个通道
        var fch = rdf.getChannel();
        //设置通道从文件的哪个位置开始写入。通过这样的方式就能达成追加操作。默认是覆盖
        fch.position(fch.size());

        //获取一个字节缓冲区，长度为1024，缓冲区可以随时设置大小。但是要注意缓冲区在重新写入数据前，最好清空一下

        //这样是直接内存ByteBuffer.allocateDirect(1024)，效率极高，适合频繁的io操作。一般用于网络io。
        //这个是堆内存。
        var buff = ByteBuffer.allocate(1024);
        //将数据写入缓冲区
        buff.put("hello".getBytes(StandardCharsets.UTF_8));

        //设置缓存区的长度为当前位置。（不设置就会读到空数据）
        buff.limit(buff.position());
        //设置游标位置（不然就从刚才写入的位置操作）
        buff.position(0);

        //将缓冲区写入通道
        fch.write(buff);

        buff.clear();

        buff.limit(1024);
        //通道从文件的0号位置开始读取
        fch.position(0); //从这里我们就能看出，通道能直接操作整个文件
        var len = fch.read(buff); //可以知道读入了多少内容
        var bb = new byte[1024];

        //读取之前需要调整游标
        buff.position(0);
        buff.get(bb);
        System.out.println( new String(bb, 0, buff.position(), StandardCharsets.UTF_8) + "|");

        //如果缓冲区内容很小就直接全部哪来。会将所有已知数据拿到
        System.out.println( new String(buff.array(), 0, buff.position(), StandardCharsets.UTF_8) );

    }

    public static String getPath(String file) {
        return URLDecoder.decode(对文件进行读写.class.getClassLoader().getResource(file).toString().substring(6), StandardCharsets.UTF_8);
    }
}
