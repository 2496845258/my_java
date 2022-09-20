package 终结操作;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 终结和收集 {
    public static void main(String[] args) {
        //每个流元素使用终结操作
        Stream<Integer> stream = Stream.of( 1, 2, 3);

        //有参无返回
        stream.forEach( i->{
            System.out.println(i);
        });

        //确保终结操作顺序是原始流顺序
        stream.forEachOrdered(System.out::println);


        //收集操作, 将流中的数据保存到列表中
        ArrayList<Integer> arrayList = stream.collect( Collectors.toCollection( ArrayList::new) );
        Set<Integer> treeSet = stream.collect(Collectors.toCollection( TreeSet::new) ); //用有序集合收集

        //自定义收集方式是用collect重载方法

    }
}
