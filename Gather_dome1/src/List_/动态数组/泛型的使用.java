package List_.动态数组;

import java.util.ArrayList;

// 泛型对集合的重要性
public class 泛型的使用 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add( new a() );
        arrayList.add( new b() );

        for ( var i : arrayList ) {
            ((a)i).xxx1(); //没有泛型约束，我加了个b进去你也不知道
        }
    }
}

class a {
    void xxx1() {

    }
}

class b {
    void xxx2() {

    }
}

