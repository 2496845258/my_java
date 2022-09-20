package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) throws Exception {
        var fileName = "resources/a.txt";

        //创建一个随机流
        var rd = new RandomAccessFile(getPath(fileName),"rwd");

        //通过随机流来打开通道
        var fileChannel = rd.getChannel();

        //创建字节缓冲区，并限制他的长度为1024
        var bbuf = ByteBuffer.allocate(1024);

        //将通道中的数据写入缓冲区，并查看写入的长度
        var len = fileChannel.read( bbuf );

        while ( -1 < len ) {
            //缓冲区翻转，你看你写入到缓冲区的字节是不是len，那现在的游标就在len，你如果想读，是不是得从头开始
            System.out.println( "缓冲区当前的游标位置: " + bbuf.position() + "\n当前缓冲区的限制位置：" + bbuf.limit() );
            //设置当前读取位置
            bbuf.position(0);
            //设置当前缓冲区的限制为12个字节，超过12个字节的位置无法读入。也就防止了读入12以后未写内容的空数据。
            bbuf.limit(12);

            System.out.println("缓冲区的大小：" + bbuf.capacity() + "\n缓冲区被限制的位置" + bbuf.limit());

            //设置当前游标位置一个标记
            bbuf.mark();
            //游标返回到上次设置的标记
            bbuf.reset();

            //缓冲区翻转
            //bbuf.flip(); 说明我已经准备好了，打算进行别的操作。
            //相当于 bbuf.limit( bbuf.position() ); bbuf.position(0);
            //限制为最后位置（保证不会读取到错误数据（空数据））。并重新开始读
            while ( bbuf.hasRemaining() ) {
                //从缓冲区中一个字节一个字节读入
                System.out.print( (char) bbuf.get() );
            }
            //缓冲区清空，这样缓冲区就可以存别的内容，不至于被干扰了
            bbuf.clear();
            //继续从通道中读入字节到缓冲区
            len = fileChannel.read(bbuf);
        }

        var msg = "hello worldx";

        bbuf.position(0); //重新设置游标
        //先设置缓冲区大小
        bbuf.limit(msg.length());
        //再写入内容
        bbuf.put(msg.getBytes());

        fileChannel.write(bbuf);

//        while ( bbuf.hasRemaining() ) {
//            fileChannel.write(bbuf);
//        }


        //关闭通道
        fileChannel.close();


    }

    public static String getPath(String fileName) {
        return URLDecoder.decode(Test.class.getClassLoader().getResource(fileName).toString().substring(6), StandardCharsets.UTF_8);
    }
}
