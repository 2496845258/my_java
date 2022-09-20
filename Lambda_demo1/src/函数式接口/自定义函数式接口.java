package 函数式接口;

public class 自定义函数式接口 {
    public static void main(String[] args) {
        //我们知道，最终还是有可能需要自己定义函数式接口，那么在使用你的库的时候需要配合部分文档来使用

        //使用自己定义的函数式接口，来创建lambda表达式
        MyFunction< String, Integer, Double, Long > myFunction = (b, c, d) -> {
            return "" + b + " " + c  + " " + d;
        };

        System.out.println( myFunction.xxx(1, 0.1, 10L) );
    }
}
@FunctionalInterface //函数式接口注解，会帮你检查你写的函数式接口是否符合标准
interface MyFunction< A, B, C, D> { //说明我这个接口可以接受4个类型
    A xxx( B b, C c, D d ); //方法中的参数和返回类型都被修饰好了
}

