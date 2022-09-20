package 流中元素的处理;

import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {

        //原本是int，后来变成了string
        //map处理每一个元素
        Stream.of( 1, 2, 3).map( i -> new String(i+"") ).forEach(System.out::println );
    }
}
