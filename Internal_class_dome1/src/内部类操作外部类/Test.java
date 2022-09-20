package 内部类操作外部类;

public class Test {
    private static int a = 10;

    private int b = 20;
    private class Hello1 {

        private int b = 30;
        {
            //不允许有静态方法和字段
            a = 10;
            Test.this.b = 10; //通过外部类的名称.this就能访问外部类的实例内容

            this.b = 30;    //访问的是自己的实例内容
        }
    }

    private static class Hello2 {
        static {
            Test.a = 20; //即使私有也能访问，也能有静态方法和字段
        }
    }

    public static void main(String[] args) {
        var x = new Test().new Hello1();    //使用外部类的实例的.new Hello();来实例化一个非static内部类
        var h2 = new Hello2(); //static的内部类上升为了顶级类，能访问Test的所有static的内容
    }
}
