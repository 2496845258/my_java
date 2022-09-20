package test;

import main2.IUserDao;
import main2.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        var c1 = Class.forName("main2.User");
        var m1 = c1.getDeclaredMethods();

        var arrs1 = Arrays.stream(m1).map(i->{
            return i.toString().substring( i.toString().indexOf(c1.getName()) + c1.getName().length()+1);
        }).filter(i->{
            return i.toString().startsWith("set");
        }).toArray(String[]::new);

        Arrays.stream(arrs1).forEach(System.out::println);

        var arrs2 = Arrays.stream(arrs1).map(i->{
            return i.toString().substring(i.toString().indexOf("(")+1, i.toString().indexOf(")"));
        }).toArray(String[]::new);

        Arrays.stream(arrs2).forEach(System.out::println);

        //拿到一个全被注入的User
        var user = c1.getConstructor().newInstance();
        var x = c1.getMethod("setAccount", Class.forName("java.lang.String"));
        x.invoke(user,"hhhh");
        System.out.println(user);

        var list = new ArrayList<User>();
//        list.add(user);
        //复制




    }
}
