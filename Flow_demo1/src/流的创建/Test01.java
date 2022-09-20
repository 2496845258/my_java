package 流的创建;

import java.util.*;
import java.util.stream.Stream;

public class Test01 {
    //流的意义是为了更好的操作集合
    public static void main(String[] args) {
        // Stream.of 将一组条目变成流
        Stream.of("hello", "world").forEach( System.out::println );
        Stream.of(1, 2 ).forEach( System.out::println );

        //定义两个Collection
        List<String> a = Arrays.asList( "hello", "world" );
        List<String> b = Arrays.asList( "a b c d e".split(" ") );

        a.stream().map( x -> x + "|" ).forEach(System.out::println);
        a.stream().map( x -> x + "|" ).forEach(System.out::print);
        System.out.println();
        //把集合变成流， map是lambda 表达式用于给集合中的每个元素进行操作，forEach接收一个方法引用，用于输出集合中的每个元素
        b.stream().map( x -> x + "|" ).forEach(System.out::print); //map方法中表达式的x表示每一个元素
        //通过上面就很明白，可以直接说上面的每个方法具体执行到的是集合中的每个元素，而不是集合本身
        System.out.println();
        for( var i : b ) {
            System.out.print(i + "|");
        }

        //map集合
        System.out.println();
        Map<String, String> m = new HashMap<>();
        m.put("A", "a");
        m.put("B", "b");

        m.entrySet().stream().map( x -> x.getKey() + ":" + x.getValue() ).forEach(System.out::print);

        System.out.println();
       for ( var i : m.keySet() ) { //m.keySet返回一个键的集合
           System.out.print(i + ":" + m.get(i));
       }



    }
}
