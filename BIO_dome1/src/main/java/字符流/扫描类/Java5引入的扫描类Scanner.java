package 字符流.扫描类;

import java.io.FileInputStream;
import java.util.Scanner;

public class Java5引入的扫描类Scanner {
    public static void main(String[] args) throws Exception {
        var url = "./IO_NIO_dome1/src/main/resources/hello.txt";
        var in = new Scanner(new FileInputStream(url)); //只要是InputStream的子类都能用

        while ( in.hasNext() ) {
            System.out.println( in.nextLine() );
        }
    }
}
