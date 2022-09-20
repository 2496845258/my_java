package List_.动态数组._arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class 未知数据个数 {
    public static void main(String[] args) {
        //List承诺以特定的顺序维护元素，List接口在Collection上新增了一些方法
        ArrayList<Integer> arrayList = new ArrayList<>();

        //1、增加
        arrayList.add(7);
        arrayList.add(8);

        //在某个索引处插入，原本位置如果有值，则往后移动
        arrayList.add(0, 99);

        //插入一段List, 只要是List的都能插入，这样的效果是在末尾插入一段新序列
        arrayList.addAll(arrayList.size(), Arrays.asList(1,2) );

        //2、查找
        arrayList.get(0);

        Integer a = 1; //自动装箱 == Integer.valueof(1)
        arrayList.add(a);   //添加一个对象
        System.out.println("对象a是否存在:" +  arrayList.contains(a)); //查看某个对象是否存在
        System.out.println("对象a的位置:" + arrayList.indexOf(a));   //获取某个对象的位置 -1表示找不到
        arrayList.remove(a); // 移出/查找某个对象时，使用的是对象的equals()来进行比较，如果对象重写了该方法，可能会有影响

        //如果你觉得里面有重复的元素，或者说对象执行的equals方法结果相同，那就会有多个重复的值，那你想多个删除的话就得
        while(arrayList.contains(a)) { //移出应该只会移出一个
            arrayList.remove(a);
        }

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("让类可以存入集合");
        arrayList2.add("让类可以存入集合");

        arrayList2.remove("让类可以存入集合");     //因为字符串对象重写了equals方法，所以即使对象本身不相同但是能移出。
        System.out.println(arrayList2);    //根据输出我们发现，一次remove()只会移出一次

        //3、更改
        arrayList.set(0, 9);

        //4、删除
        arrayList.remove(0); //移出索引为0位置的元素，然后后面的所有元素向前移动

        //删除全部元素
        arrayList.clear();
        System.out.println("该List为空? " + arrayList.isEmpty());

        //5、复制
        ArrayList<Integer> linkedList3 = new ArrayList<>(arrayList);



    }
}
