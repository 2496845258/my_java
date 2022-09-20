package Map_.记录._record;

import java.util.Map;

public class 数据传输对象 {
    public static void main(String[] args) {
        //想要一个对象能成为Map中的键，equals() 和 hashCode() 方法不能被破坏

        //其实引入record就是帮你规范化创建键值对对象
        var xx1 = new myKey("hello1", 1);
        var xx2 = new myKey("hello2", 2);

        //获取键值对对象中的键值对
        System.out.println( xx1.id() ); //建是参数名，值是参数
        System.out.println( xx1.name() );

        //可以把键值对对象当作map中的键
        Map<myKey, String> map = Map.of(xx1, "6666", xx2, "7777" ); //也可以var map = Map.of();
        System.out.println(map);


    }
}

//jdk16 record 记录
record myKey( String name, Integer id ) {
    //可以加入static的东西，废话你都用static了，都脱离对对象本身限制了
    static void sayHello() {

    }
    //可写可不写，编译器会自动帮你写全参构造
//    myKey( String name, Integer id ) {
//        this.name = name;
//        this.id = id;
//    }

    myKey { //紧凑构造器, 构造器和紧凑构造器不能同时存在。处理数据一般都是使用紧凑构造器
        id++; //可以对初始化的值进行修改
    }
}

