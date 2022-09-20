package main2;

public class Zi{
    public static String str = "666";
    static {
        System.out.println("静态代码块在变量被创建的之后就执行");
    }

    {
        System.out.println("Zi类正在被实例化");
    }

    private int a = 10;
    public void show() {
        System.out.println(a);
    }


    public static void main(String[] args) {
        System.out.println(Zi.str);

        new Zi(); //实例会被垃圾回收机制清理。
        //jvm在
    }
}
