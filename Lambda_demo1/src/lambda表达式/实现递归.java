package lambda表达式;

public class 实现递归 {
    static Idigui digui = null;
    public static void main(String[] args) {
        //编写函数, 参数有1个，有返回值，跟接口中定义的一毛一样
        digui = (n) -> {
            return n == 0 ? 1 : n * digui.xxx( n - 1 );
        };

        //使用函数
        System.out.println( digui.xxx(3) ); // 3*2*1

    }
}

interface Idigui {
    int xxx( int msg );
}
