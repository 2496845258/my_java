package 修改流元素;

import java.util.Arrays;

public class 查看流中的元素 {
    public static void main(String[] args) {
        //peek可以查看流中的元素，接收的是有参无返回的方法，所以也就不会修改流中的元素
        Arrays.stream(new int[]{1,2,3,4}).peek(System.out::println).forEach(System.out::println);

    }
}
