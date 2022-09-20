package 终结操作;

import java.util.Optional;
import java.util.stream.Stream;

public class Optional类型 {
    public static void main(String[] args) {
        //findFirst() 返回包含第一个元素的Optional,如果流为空返回Optional.empty
        System.out.println( Stream.of().findFirst() );

        //返回包含任何元素的Optional
        System.out.println( Stream.of(1,2,3).findAny());

        Optional<String> optional = Stream.of("123", "456").findFirst();
        if ( optional.isPresent() ) { //不为空返回true
            //get可以获取对象
            System.out.println( optional.get() + " " + optional.isEmpty() ); //为空返回true
        }

        //还有附带检查并且操作的版本, 便捷函数自己去了解
        //optional.ifPresent();
    }
}
