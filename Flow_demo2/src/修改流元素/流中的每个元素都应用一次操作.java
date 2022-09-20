package 修改流元素;

import java.util.Arrays;
import java.util.stream.Stream;

public class 流中的每个元素都应用一次操作 {
    public static void main(String[] args) {

        //map可以为流中的元素应用一次函数，并且输出的结果继续传递
        Arrays.stream( new int[]{1,2,3}).map( (n) -> {
            Integer x = n + 1;
            return x; //为什么是返回这个类型是因为自动装箱，在流中的每一个基本数据类型都会自动装箱，不然没法操作。
        }).forEach(System.out::println);

        Stream.of( 1, 2, 3 ).map( n -> {
            return n + "";
        }).forEach(System.out::println);
        //我们可以看到输入的是Integer 返回 String类型也可以，那为什么上面那个流不行，原因是上面那个流已经是Integer流了
    }
}
