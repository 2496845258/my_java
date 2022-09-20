package 扫描输入;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class 让字符流像控制台输入 {
    public static void main(String[] args) {
        var in = new BufferedReader(new StringReader("hello\nworld\n22\n3.14"));
        try {
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println( Integer.valueOf( in.readLine()) + 1 );
            System.out.println( Double.valueOf( in.readLine()) + 0.0015926 );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
