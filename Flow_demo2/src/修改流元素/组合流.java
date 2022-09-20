package 修改流元素;

import java.util.ArrayList;
import java.util.stream.Stream;

public class 组合流 {
    public static void main(String[] args) {
        //很明显，flatMap() 接受一个有参，返回流的方法。
        Stream.of( 1, 2, 3).flatMap( i -> {
                i = i*10;
                return Stream.of( i+1, i+2, i+3);
            }).forEach(System.out::println);

        //使用组合流完成双循环的效果
        var a = new ArrayList<Integer>();
        a.add(5);
        a.add(3);
        a.add(2);
        for(var i = 0; i < a.size(); i++ ) {
            for ( var j = i; j < a.size(); j++ ) {
                if ( a.get(j) < a.get(i) ) {
                    var t = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, t);
                }
            }
        }

        System.out.println(a);

        a.add(1);
        a.add(7);
        a.add(6);

        a.stream().flatMap( i -> a.stream().map( j -> j) );

    }
}
