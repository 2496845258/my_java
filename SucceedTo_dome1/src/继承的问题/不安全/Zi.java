package 继承的问题.不安全;

public class Zi extends Fu{
    int a = 5;

    public Zi() {
        super();
        System.out.println("子类构造完成");
    }

    @Override
    public void xxx() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        new Zi();
    }
}
