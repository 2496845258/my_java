package Map_.键值对._hashMap;

import java.util.HashMap;
import java.util.Map;

public class 快速存取 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put( "1", 1);
        hashMap.put( "hello2", 2);
        //这里使用了自动装箱，我们没法在集合中使用基本数据类型

        //查询某个键值对的情况
        System.out.println( hashMap.containsKey("1") );     //查询键
        System.out.println( hashMap.containsValue(1) );     //查询值

        //查看全部
        System.out.println( hashMap.keySet() );     //返回的都是对类型的Collection, 便于操作
        System.out.println( hashMap.values() );

        //遍历
        for ( var i : hashMap.entrySet() ) {
            System.out.print(i + "|" + i.getKey() + " " + i.getValue());
            System.out.println();
        }

        //查看
        System.out.println( hashMap.get("hello2") );

        //移除键值对，并返回值
        hashMap.remove("hello2");
        hashMap.put("666",5);

        //精确删除，返回true/false
        hashMap.remove("666", 5);
    }
}
