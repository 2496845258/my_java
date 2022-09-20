package test;

import main2.IUserDao;
import main2.User;
import main2.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class MyProxy {
    public static void main(String[] args) throws Exception {
        var a = IUserDao.class;

        var list = Xxx.oo(a).findAll();
        System.out.println(list);
    }

    static class Xxx {
        public static <T> T oo(Class<T> c ) {
            return (T)Proxy.newProxyInstance(c.getClassLoader(), new Class[]{c}, new In());
        }
    }

}
class In implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method); //可以查看需要增强的方法
//        return method.invoke(new UserDaoImpl(), args); //已经有真是实现类

        var list = new ArrayList<>();
        var user1 = Class.forName("main2.User");

        var m1 = user1.getMethod("setAccount", String.class);
        var u = user1.getConstructor().newInstance();
        m1.invoke(u, "123456");
        var user = new User();
        user.setAccount("123");
        user.setPasswd("456");
        user.setUserid(5);

        list.add( user );
        list.add( u );
        return list;
    }
}