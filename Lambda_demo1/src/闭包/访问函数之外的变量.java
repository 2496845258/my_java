package 闭包;

import java.util.function.IntSupplier;

public class 访问函数之外的变量 {
    private static class xxx { //对内部类使用static, 就能让它像正常的类一样使用
        private int i = 0;
        //supplier无参，任何返回
        IntSupplier jiayi( int x ) { //这个应该是返回int
            //为什么叫最终变量，最主要是你得传入函数中，函数要保证不可变
            final int j = 1; //标记为最终变量，局部变量就不会随着退出方法作用域而失效。这样在外界访问也符合逻辑
            int d = 0; //实际的最终变量，虽然没有加final, 但实际上就是final

            //那如果非要修改呢
            int[] a = new int[]{1};
            a[0] = 2;
            a[0] = 3;

            //但其实，如果他作用于函数，a就是final, 他永远指向这个数组不能被二次修改引用了

            return () -> x + this.i++ + j + d;
        }
    }

    public static void main(String[] args) {

        var a = new xxx();

        IntSupplier b1 = a.jiayi(10);
        IntSupplier b2 = a.jiayi(10);

        //通过结果发现, 函数能读取函数之外的变量，能保存函数之外的对象中的字段到外界。这是符合在类中的方法从操作
        System.out.println(b1.getAsInt());
        System.out.println(b2.getAsInt());
    }
}
