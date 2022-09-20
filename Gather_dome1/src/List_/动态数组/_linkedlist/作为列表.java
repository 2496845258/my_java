package List_.动态数组._linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class 作为列表 {
    public static void main(String[] args) {
        //准备数据
        LinkedList<String> list = new LinkedList<>();
        list.add("hello1");
        list.add("hello2");
        list.add("hello3");

        //方法和arraylist一样, 这些都是List接口提供的
        list.add( list.size(), "hello4");
        System.out.println( list.contains("hello4") );
        System.out.println( list.indexOf("hello4") );
        System.out.println( list.get( list.indexOf("hello4") ) );
        list.set(4, "hello44");
        list.remove("hello44");

    }
}
