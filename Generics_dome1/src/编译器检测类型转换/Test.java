package 编译器检测类型转换;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        var arr1 = new DongtaiArray<IUserDao>();
        arr1.add(new IUserDaoImpl());

        var arr2 = new DongtaiArray<Fu>();
        arr2.add(new Zi("z1"));

        var arr3 = new DongtaiArray<Zi>();
        arr3.add(new Zi("z2"));
        arr3.add(new Zi("z3"));

        //父类赋值给子类，子类赋值给父类都可以
        arr3.pinjie(arr2);

        for( var i : arr3 ) {
            System.out.println(i);
        }

        for (var i : arr3.toArray(Zi.class)) {
            System.out.println(i);
        }

        var li = new ArrayList<String>();

    }
}
