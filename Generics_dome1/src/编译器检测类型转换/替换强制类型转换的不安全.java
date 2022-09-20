package 编译器检测类型转换;

public class 替换强制类型转换的不安全 {

    private interface ImyUser{
        void sayHello();
    }

    private static class ImyUserImpl implements ImyUser {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }
    public static void main(String[] args) {

        //强制转换, 我明明写的是Integer, 编译器却允许我转换为String，运行的时候就会报错
//        System.out.println( (String) i);
        "".equals(Integer.valueOf(1));

        zuanhuan(new ImyUserImpl());
        var arr = new DongtaiArray<String>();
        arr.add("hello");
        arr.add("world");
        arr.add("world2");
        arr.add("world3");

        System.out.println(arr.size());
        System.out.println( arr.remove() );
        System.out.println( arr.remove() );
        System.out.println( arr.remove() );
        System.out.println( arr.remove() );
    }

    public static <T extends ImyUser> void zuanhuan(T t ) {
        t.sayHello();
    }

    // 一开始的<> 表示这个方法的定义泛型情况
    public static <T extends ImyUser, U extends Integer> int Xxx(T t, U u) {
        return 1;
    }
}
