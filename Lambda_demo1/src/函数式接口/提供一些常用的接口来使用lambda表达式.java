package 函数式接口;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class 提供一些常用的接口来使用lambda表达式 {
    public static void main(String[] args) {
        //你总不能每次需要使用lambda表达式都去定义一个接口吧
        //大多数情况下我们都用一些常见的情况，那么java帮我们写了一些

        //无参
        Runnable runnable = () -> {
            //这个接口无参无返回
        };
        runnable.run(); //使用

        //无参，任意返回
        Supplier supprr = () -> {
            return "666";
        };
        System.out.println( supprr.get() );

        //有1个参，无返回
        Consumer consumer = (n) -> {
            n = new String("hello"); //只做处理，并且无法影响外部n本身
        };
        String str = "777";
        consumer.accept(str);
        System.out.println( str );

        //1参，返回相同数据类型
        UnaryOperator unaryOperator = (n) -> {
            return n + " " + "world";
        };
        System.out.println( unaryOperator.apply("hello") );

        //1参，返回值不同类型
        Function function = (n) -> {
            return "hello";
        };
        System.out.println( function.apply("xxx"));

        //。。。。还有很多接口，但是如果你真的觉得麻烦也可以在自己定义，但是不是规范化，别人可能并不知道这个接口是用来干嘛的

    }
}
