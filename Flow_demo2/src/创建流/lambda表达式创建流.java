package 创建流;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.stream.Stream;

public class lambda表达式创建流 {
    public static void main(String[] args) {
        //1、generate 接受一个无参，任意返回的lambda的表达式
        Stream.generate( () -> new String("123") ).limit(3).forEach(System.out::println);

        //有什么用呢？比如有时候你要用数组对象哎你看这不就有用了
        //或者工厂类

        //2、iterate() //前面这个0表示初始值，会将方法的返回结果结果当作下一次方法的参数的值，并且存入流中
        Stream.iterate( 0, i -> ++i ).limit(5).forEach(System.out::println);
    }
}
