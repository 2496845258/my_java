package 终结操作;

import java.nio.file.OpenOption;
import java.util.Optional;
import java.util.stream.Stream;

public class 组合所有流元素 {
    public static void main(String[] args) {

        //reduce接受 2同类型参，返回1个同类型结果的方法
        //这样能求遍历求最大值
        Optional<Integer> optional = Stream.of(1,2,3,4,5,6).reduce( (i1, i2) -> {
            Integer x = 0;
            x = i1 > i2 ? i1 : i2;
            return x; //返回的元素会成为流中的元素，但是传进来的两个元素就不会再进行reduce了
        });

        //ifPresent 接受一个 有参无返回的方法
        optional.ifPresent(System.out::println );
    }
}
