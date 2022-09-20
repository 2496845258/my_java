package 迭代器;

import java.util.ArrayList;
import java.util.Iterator;

public class 迭代器在集合中的使用 {
    public static void main(String[] args) {
        //准备数据
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello1");
        arrayList.add("hello2");
        arrayList.add("hello3");
        arrayList.add("hello4");
        arrayList.add("hello5");

        //获取迭代器
        Iterator<String> iterator = arrayList.iterator();

        //常见使用
        while ( iterator.hasNext() ) {//判断还有没有元素。迭代器原本的目的就是为了在未知个数的时候遍历
            String str = iterator.next();   //取出并后移动
            System.out.println(str);
        }

        for ( var i : arrayList ) {
            System.out.println(i);  //增强for循环是使用迭代器来完成的遍历
        }

        iterator = arrayList.iterator(); //重新获取迭代器对象。因为迭代器本身消耗很少，可以随意创建, 并且，上次的迭代器已经迭代结束了
        System.out.println();

        for ( int i = 0; i < arrayList.size(); i++ ) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(arrayList); //知道为什么会输出2个吗，因为arrayList.size()是会变小的，因为你移出了数据


    }
}
