package 方法内部类;

public class 操作局部变量 {
    //不可被序列化
    private volatile int a = 10;

    private static interface Xxx {
        void sayHello();
    }

    public static void main(String[] args) {
        var str = "Hello";
        System.out.println(str.hashCode());
        class Xxx {
            void sayHello() {
                System.out.println( str.hashCode());
            }
        }
        new Xxx().sayHello();
        int a;
        for( var i = 0; i < 1; i++ ) {
            a = 4;
        }

        System.out.println(Integer.valueOf("666"));
        System.out.println(String.valueOf(1));
        System.out.println(Double.valueOf("3.14"));

        //System.out.println(a); //方法在入栈的时候，参数表的局部变量需要给定一个值来正确初始化
    }
}
