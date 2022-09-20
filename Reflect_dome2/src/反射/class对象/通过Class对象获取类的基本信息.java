package 反射.class对象;

public class 通过Class对象获取类的基本信息 {
    public static void main(String[] args) throws Exception {
        var str = new String("123");

        var c1 = str.getClass();

        //1、获取类的名称
        System.out.println("全限定名：" + c1.getName() );
        System.out.println("类名：" + c1.getSimpleName() );
        System.out.println("包名：" + c1.getPackage() );
        System.out.println("返回类的修饰信息：" + c1.toGenericString());

        //2、获得构造器
        var gz = c1.getConstructor();
        var gzs = c1.getConstructors(); //返回构造器数组

        //可以获得父类，字段，方法，注解
        //3、返回类的所有接口的Class对象
        var intfs = c1.getInterfaces();

        //4、返回类的直接父类
        var fu = c1.getSuperclass();

    }
}
