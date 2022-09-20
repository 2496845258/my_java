package 迭代器;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class 迭代器和for_in {

    public static void main(String[] args) {
        //for-in使用Iterable接口来遍历序列

        var a = new myList("A B C D E".split(" "));
        for ( String x : a ) { //因为我自己定义的列表中实现了for-in 循环需要的接口
            System.out.println(x);
        }
    }
}

class myList implements Iterable<String> {
    //自己定义了一个列表
    private String[] strs = "A B C D E".split(" ");

    myList( String[] strs ) {
        this.strs = strs;
    }
    @Override   //这是接口中的默认方法，所以可以选择性的实现
    public Iterator<String> iterator() {

        // 方法内的匿名内部类
        return new Iterator<String>() {
            private int index = 0; //返回下标
            @Override
            public boolean hasNext() {
                return index < strs.length;
            }

            @Override
            public String next() {
                return strs[index++];
            }
        };
    }
}
