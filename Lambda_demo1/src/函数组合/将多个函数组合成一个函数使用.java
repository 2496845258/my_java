package 函数组合;

import java.util.function.Function;

public class 将多个函数组合成一个函数使用 {
    static Function<String, String>
            f1 = (n) -> n + "A",
            f2 = (n) -> n + "B",
            f3 = (n) -> n + "C",

            //函数组合
            f4 = f1.compose(f2),
            f5 = f1.andThen(f2),
            f6 = f1.compose(f2).andThen(f3); // ==> (f1.compose(f2)).andThen(f3)

    public static void main(String[] args) {
        System.out.println( f4.apply("")); //看结果，就是把f2的执行结果再去执行f1  ==> f1.apply( f2.apply("") )
        System.out.println( f5.apply("")); //先执行f1,再将f1的结果当作参数传给f2  ==> f2.apply( f1.apply("") )
        System.out.println( f6.apply("")); //一个意思
    }
}
