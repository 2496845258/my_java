package List_.动态数组._linkedlist;

import java.util.LinkedList;

public class 作为栈 {
    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();

        //用LinkedList提供的特殊方法形成别的数据存取结构，其一就是栈
        //栈，先进后出，永远先处理最晚添加的那个

        stack.addFirst("hello1");   //在列表开头插入
        stack.addFirst("hello2");
        System.out.println(stack);

        System.out.println( stack.getFirst() );         //返回列表的第一个元素，为空抛出异常
        System.out.println( stack.removeFirst() );      //取出并移出，列表开头的元素，如果为空，则抛出异常

        //这样写会频繁的移动元素，增加维护索引的消耗，我们可以在尾部做增删，这样写成的栈结构，已经没什么缺点了
        stack.offer( "hello3" ); //向尾部插入一个元素，当然add()也是在尾部
        System.out.println( stack.getLast() );      //查看末尾最后一个元素
        System.out.println( stack.removeLast() );   //移出并返回最后一个元素

        //当然，其实一切都能用get, add, remove 来做，不是吗？是的。查看开头get(0)，查看末尾就get(size()-1)
        //那为什么还需要这些方法呢？语义化更容易理解和维护
        //而且还有可能，因为removeLaset() 是明确取出最后一个元素，我可以省去检查和维护索引的动作
        //可能get( size-1 ), remove( size-1 ), 也能达到相同效果，但是可能会取走后，进行通用的索引检查和维护
    }
}
