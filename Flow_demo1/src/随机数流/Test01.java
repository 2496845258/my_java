package 随机数流;

import java.util.Random;

public class Test01 {
    public static void main(String[] args) {
        Random random = new Random();

        //生成int的随机数，范围0-10，并获取4个，最后打印
        random.ints(0,10).boxed().limit(4).forEach(System.out::println);

        //生成3个范围是0-1的double类型的浮点数
        random.doubles(0,1).boxed().limit(3).forEach(System.out::println);
    }
}
