package test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        new Thread(()->{
            try {
                var i = 0;
                while (true) {
                    Thread.sleep(1000);
                    var in = new Scanner(new File("1.txt"));
                    while (in.hasNext()){
                        System.out.println(in.nextLine());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
