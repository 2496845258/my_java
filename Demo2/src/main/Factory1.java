package main;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class Factory1 {
    private static ResourceBundle rb = ResourceBundle.getBundle("hello");

    private static final Factory1 factory1 = new Factory1();
    private Factory1(){}

    public static Factory1 getInstance() {
        return factory1;
    }

    public IUser getUser1() throws Exception {
        return (IUser) Class.forName(rb.getString("user1")).getConstructor().newInstance();
    }
    public IUser getUser2() throws Exception {
        return (IUser) Class.forName(rb.getString("user2")).getConstructor().newInstance();
    }
    public IUser getUser3() throws Exception {
        return (IUser) Class.forName(rb.getString("user3")).getConstructor().newInstance();
    }

    public <T> T getUser(Class<T> c, String str) throws Exception {
        return (T)Class.forName(rb.getString(str)).getConstructor().newInstance();
    }


    public static void main(String[] args) throws Exception {
        Factory1.getInstance().getUser(IUser.class, "user1").sayHello();
    }
}
