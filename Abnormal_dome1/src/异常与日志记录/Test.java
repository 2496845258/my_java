package 异常与日志记录;

import java.io.StringWriter;
import java.util.Random;
import java.util.logging.Logger;

public class Test {
    public static void main(String[] args) {
        Random random = new Random(47);
        int i = random.nextInt(10);
        int i2 = random.nextInt(10);
        System.out.println(i2);
    }
}
class MyLogException extends Exception {
    private static Logger logger = Logger.getLogger("这是什么意思啊");
    MyLogException() {
        StringWriter trace = new StringWriter(); // 用于将打印的调试内容组装成String

        printStackTrace();

    }
}
