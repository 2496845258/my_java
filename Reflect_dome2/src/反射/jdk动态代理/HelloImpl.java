package 反射.jdk动态代理;

public class HelloImpl implements Hello, World{
    @Override
    public void sayHello() {
        System.out.println("我是真是实现类");
    }

    @Override
    public String bye() {
        return "执行真是实现类的bye()方法";
    }

    @Override
    public void print() {
        System.out.println("我是World的实现类");
    }
}
