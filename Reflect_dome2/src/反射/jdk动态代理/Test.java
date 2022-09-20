package 反射.jdk动态代理;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) throws Exception{

        var clazz = Class.forName("反射.jdk动态代理.HelloImpl");
        var hello = (Hello) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), Test::kkk);
        hello.sayHello();

    }
    //方法引用，就是满足方法参数和返回值就能用
    public static Object kkk(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
