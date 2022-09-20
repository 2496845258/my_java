package main;

import java.util.ResourceBundle;

public class Factory2 {
    private static ResourceBundle rb = ResourceBundle.getBundle("hello");
    public static IUser getUser1() throws Exception {
        return (IUser) Class.forName(Factory2.rb.getString("user1")).getConstructor().newInstance();
    }
    public static IUser getUser2() throws Exception {
        return (IUser) Class.forName(Factory2.rb.getString("user2")).getConstructor().newInstance();
    }
    public static IUser getUser3() throws Exception {
        return (IUser) Class.forName(Factory2.rb.getString("user3")).getConstructor().newInstance();
    }

}
