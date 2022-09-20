package 方法引用;

public class 以方法的角度考虑复用 {
    public static void main(String[] args) {
        //现在考虑一个情况，你有个方法，它需要B接口作为参数，然后在方法里面调用B中的方法hello
        //但是你发现，A类中的方法刚好是你需要的行为，但是你又不想实现接口B重新再实现一个内容相同方法。怎么办

        //方法引用
        Aimpl aimpl = new Aimpl();
        B b = aimpl::sayHello;  //aimpl中的方法签名和B接口中的方法签名相同，我们就能进行方法引用

        //用还是用B接口中的hello方法，但是具体的内容却是Aimpl被引用的方法中的方法体
        System.out.println( b.hello("luzhao") );
    }
}
//接口A的实现类
class Aimpl {
    public String sayHello(String name) {
        return name + "跟你打招呼";
    }
}
@FunctionalInterface
interface B {
    String hello( String msg );
}
