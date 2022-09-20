package 流中流;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        //流中处理流
        Stream.of( 1, 2, 3 ).flatMap( i -> Stream.of(4, 5, 6).map( j -> i + j ) ).forEach(System.out::println);

        //组合流

    }
}
