package 反射.泛型类的引用;

import java.lang.reflect.InvocationTargetException;

public class 返回一个特定的类型 {
    public static void main(String[] args) throws Exception {
        //给一个字符串，返回具体的对象
        String msg = getOne(Class.forName("java.lang.String"));
        //使用返回到的对象
        System.out.println( msg );
    }

    public static <T> T getOne(Class clazz) {
        try {
            //使用的是空构造，非空构造很麻烦要依赖注入
            return (T) clazz.getConstructor().newInstance();
        } catch (Exception e) {
            System.err.println("对象构造失败");
            e.printStackTrace();
            return null;
        }
    }
}
