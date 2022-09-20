package 终结操作;

import java.util.stream.Stream;

public class 为流中的所有元素进行逻辑判断 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of( 1,2,3,4,5,6);

        //短路与
//        System.out.println(stream.allMatch(i -> {
//            boolean flag = i > 0;
//            return flag;
//        }));

//        //短路或
//        System.out.println(stream.anyMatch( i -> {
//            return i > 5;
//        }));

        //全假
        System.out.println(stream.noneMatch( i -> i > 10));
        //以上操作过后的流无法复用

    }
}
