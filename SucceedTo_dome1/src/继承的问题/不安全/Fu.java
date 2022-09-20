package 继承的问题.不安全;

public class Fu {

    public Fu() {
        xxx();
        System.out.println("父类构造完成");
    }

    public void xxx() {
        System.out.println("hello");
    }
}
