package Set_.集合._hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 快速无序 {
    public static void main(String[] args) {
        //set 和 Collection有相同的接口，不会有额外的功能，一个set就是一个Collection, 也没有通过抽象类来进行选择性实现
        //通过哈希算法来去重，比通过挨个遍历去重快多了
        //集合最重要的是查找，所以性能最佳的HashSet就是首选

        //没有额外功能，就不需要用子类来特殊构造
        Set<String> hashSet = new HashSet<>();

        hashSet.add("hello1");
        hashSet.add("hello2");
        hashSet.add("hello2");
        hashSet.add("hello2");
        hashSet.add("hello3");
        hashSet.add("world");   //即使我是最后添加也能到前面，无序

        Collections.addAll( hashSet, "A B C D".split(" ")); //每个Collection都可以这样添加元素

        //查找全部
        System.out.println(hashSet);

        //查询, 当去除元素重复的时候，保留的就是特征值了，对特征值一般就是查询
        System.out.println( hashSet.contains("hello2") );
        System.out.println( hashSet.contains("666") );

        //如果你想要操作那就转成方便操作的数据结构
        ArrayList<String> arrayList = new ArrayList<>(hashSet); //反正这些构造函数都能接受一个Collection
        //所以你也可以转回来然后, 达到去重的目的
        hashSet = new HashSet<>(arrayList);
    }
}
