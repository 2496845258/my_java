package List_.动态数组._arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//动态列表的生成
public class 已知数据个数 {
    public static void main(String[] args) {

        //情况1，已知数据，生成一个不可变改变的列表，底层是数组
        List<Integer> list1 = Arrays.asList(4,5,6);
        list1.set(0,8); //修改数据
        list1.forEach( i -> System.out.print(i + " "));
        System.out.println();

        //情况2、对象类型的数组，创建不可变的列表
        Integer[] a = new Integer[]{1, 2, 3, 4};
        List<Integer> list2 = Arrays.asList(a);         //Arrays.asList() 能将对象类型的数组，转换为对应的List
        list2.forEach( i -> System.out.print(i + " ")); //Collection.addAll() 也能

        //情况3，如果你想生成可变数组，使用add(), remove()方法
        Integer[] b = new Integer[]{1, 2, 3, 4};
        ArrayList<Integer> arraysList = new ArrayList<>(Arrays.asList(b));  //已知数组生成可变列表
        
        int[] x = new int[]{1,1};
        ArrayList<Integer> arrs = new ArrayList<>();
        for ( var i : x ) {
            arrs.add(i);
        }

        System.out.println();
        Iterator<Integer> it = arrs.iterator();
        while ( it.hasNext() ) {
            System.out.println("index:" + arrs.indexOf(it.next())); //我就知道妈的，自动装箱不算对象找不到位置。
            //结论，当你需要在list中需要数据的索引，并且是非基本数据类型的时候，就得传统遍历
        }
        
    }
}
