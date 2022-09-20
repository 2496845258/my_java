package 高阶函数;

import java.util.function.Function;

public class 函数当作参数或返回值 {
    static class Xx {
        public Integer conn( FunTest funTest, String msg ) { //这个方法使用传入的函数对数据进行了处理
            Integer index = funTest.apply(msg);
            index = index * 10;
            return index;
        }

        public FunTest conn2( FunTest in ) {
                return null;

        }


    }
    public static void main(String[] args) {
        Xx x = new Xx();
        int a = x.conn( (n) -> {
            return Integer.valueOf(n) ;
        }, "64");

        //使用或返回函数的函数，就叫高阶函数
        System.out.println(a);


    }
}

//为接口起一个别名（也因为继承是单一的）
interface FunTest extends Function<String, Integer> {

}
