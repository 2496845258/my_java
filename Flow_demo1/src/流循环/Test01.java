package 流循环;

import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class Test01 {
    public static void main(String[] args) {
        //啊这....forEach接受一个Runnable接口的lambda表达式。其实这就是一个for-in循环，i是循环因子
        range(0, 3).forEach( i -> System.out.println("hello" + i) );

        Runnable x1 = () -> System.out.println("hello");
        range(0, 3).forEach( i -> x1.run() );

        Runnable x2 = Test01::xxx;
        range(0, 3).forEach( i -> x2.run() );

        //迭代运算，可以将每一次的计算结果保存到流中，然后又作为下一次计算的参数
        Stream.iterate(10, i -> { return 10*i;} ).limit(3).forEach(System.out::println);
    }


    static void xxx() {
        System.out.println("xxx");
    }
}
