package 创建流;

import java.util.Arrays;

public class 通过数组创建流 {
    public static void main(String[] args) {
        Arrays.stream( new int[]{1,2,3}).forEach(System.out::println);
    }
}
