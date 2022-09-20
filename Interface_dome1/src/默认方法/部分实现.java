package 默认方法;

public class 部分实现 {
    interface xx1 {
        //java 8 默认方法
        default void sayHello() {
            System.out.println("hello");
        }

        void x1();
    }

    class xx2 implements xx1 {
        @Override
        public void x1() {
            System.out.println("必须实现的方法");
        }
    }
    public static void main(String[] args) {
        var a = new 部分实现();

    }
}


