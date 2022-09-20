package List_.动态数组._arraydeque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class 栈 {
    public static void main(String[] args) {
        //因为java 1.0 就提供了Stack 类，但是设计有问题，为了向后兼容便没有重构，java6 使用ArrayDeque来实现
        //Deque是一个接口
        Deque<String> stack = new ArrayDeque<>();

        stack.push("hello1");
        stack.push("hello2");
        stack.push("hello3");   //压入

        while ( stack.isEmpty() == false ) {
            System.out.println( stack.pop() );  //取出
        }

        //如果想要自定义一个栈类，不要去继承，建议去组合，如果直接继承很有可能引入很多必须实现或者需要重构的方法。可能对你没意义
    }
}
