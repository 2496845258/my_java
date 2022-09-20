package List_.动态数组._linkedlist;

import java.util.LinkedList;

public class 作为队列 {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        //本身队列就不考虑中间取走元素，所以拿List频繁维护元素索引的数据结构来实现，并不合适, 这里只是一种无奈的写法
        //当然，你可以自己造链表来用。。。。。

        queue.addLast("让类可以存入Map");                 //尾部插入
        System.out.println( queue.getFirst() );    //头部查看
        System.out.println( queue.removeFirst() ); //头部取出
    }
}
