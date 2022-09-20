package 终结操作;

import java.util.Arrays;
import java.util.stream.Stream;

public class 将流转为为数组 {
    public static void main(String[] args) {
        //把数组转为为流，再转换为数组
        int[] a = Arrays.stream( new int[]{1,2,3}).toArray();

        //每个流元素使用终结操作
        Stream<Integer> stream = Stream.of( 1, 2, 3);

        //有参无返回
        stream.forEach( i->{
            System.out.println(i);
        });

        //4确保终结操作顺序是原始流顺序
        stream.forEachOrdered(System.out::println);

        //
    }
}
