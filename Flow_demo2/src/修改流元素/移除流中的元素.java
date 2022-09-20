package 修改流元素;

import java.util.Arrays;

public class 移除流中的元素 {
    public static void main(String[] args) {

        //移除特定元素。filter 接受一个有参，boolean类型返回的方法，只有为true才会保留
        Arrays.stream( new int[]{1,2,3}).filter( (n) -> {
            boolean a = false;
            if ( n > 1 ) {
                a = true;
            }
            return a;
        }).forEach(System.out::println);


        //移除重复元素
        Arrays.stream( new int[]{1,1,2,2,3,3}).distinct().forEach(System.out::println);
    }
}
