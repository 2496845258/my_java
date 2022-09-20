package test;

import main2.User;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws Exception {
        var name = "main2.User";
        var x = Class.forName(name).getConstructor().newInstance();

        var i = Class.forName("main2.User").cast(new User());


        new Thread(()->{
            try {
                var j = 0;
                while (true) {

                    Thread.sleep(1000);
                    j++;
                    System.out.println("第"+ j +"读取的结果"+ "666");
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
