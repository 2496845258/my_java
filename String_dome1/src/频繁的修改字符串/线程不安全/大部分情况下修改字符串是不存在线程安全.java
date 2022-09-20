package 频繁的修改字符串.线程不安全;

public class 大部分情况下修改字符串是不存在线程安全 {
    public static void main(String[] args) {
        StringBuilder strder = new StringBuilder();

        //添加字符串
        strder.append("你好"); //拥有重载的方法可以添加基本数据类型+String类型

        System.out.println(strder.toString());
    }
}
