package 反射.class对象;

public class 获取class对象 {
    public static void main(String[] args) throws Exception {
        var str = new String("13");

        //1、通过限定名获取类的Class对象
        var c1 = Class.forName("java.lang.String");

        //2、通过类的对象获取类的class对象
        var c2 = str.getClass();

        //3、通过强制转换限定
        var c3 = (Class<String>) Class.forName("java.lang.String");
    }
}
