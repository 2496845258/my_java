package 创建流;

import java.util.Random;
import java.util.stream.Stream;

public class 已知数据创建流 {
    public static void main(String[] args) {
        //1、创建流，然后什么都不做
        Stream.of( new String("134"), Integer.valueOf(1), "777", 2);

        //2、查看流中的元素
        //可以使得流中的每个元素都应用到forEach的方法
        Stream.of( new String("134"), Integer.valueOf(1), "777", 2).forEach(System.out::println);
        //特殊一点的打印,lambda表达式
        Stream.of( new String("134"), Integer.valueOf(1), "777", 2).forEach( i -> System.out.print(i + ""));

        //创建随机范围在0-10的int类型的数组成的流
        Stream stream = new Random(47).ints(0, 10).boxed();
        stream.limit(3).forEach(System.out::println); //取出3个并输出


    }
}
