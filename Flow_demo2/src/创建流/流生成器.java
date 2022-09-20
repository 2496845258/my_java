package 创建流;

import java.util.stream.Stream;

public class 流生成器 {
    public static void main(String[] args) {
        //未知数据个数生成流
        Stream.Builder<String> builder = Stream.builder(); //创建可以存未知个数元素的流

        //添加元素
        builder.add("Hello");
        builder.add("World");

        //结束添加, 并生成流: build()
        builder.build().map( i -> i + " ").forEach(System.out::println);


    }
}
