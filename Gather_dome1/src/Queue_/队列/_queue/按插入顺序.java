package Queue_.队列._queue;

import java.util.LinkedList;
import java.util.Queue;

public class 按插入顺序 {
    public static void main(String[] args) {
        //LinkedList实现了Queue
        Queue<String> queue = new LinkedList<>();

        queue.offer("hello1"); //入队
        queue.offer("hello2"); //入队
        queue.offer("hello3"); //入队

        //查看
        System.out.println( queue.peek() ); //查看队头，为空返回null
        System.out.println( queue.element() ); //查看队头，为空抛出异常

        //取出/出队
        System.out.println( queue.poll() ); //出队，为空返回null
        System.out.println( queue.remove() ); //出队，为空抛出异常

        System.out.println( queue );
    }
}
