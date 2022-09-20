package 单例模式.懒汉模式;

public class 单线程下的懒汉模式 {
    private static class Hello {
        private static Hello hello;
        private Hello() {

        }
        public static Hello getOne() {
            if ( null == hello ) {
                hello = new Hello();
            }
            return hello;
        }
        public void sayHello() {
            System.out.println("hello world");
        }
    }

    public static void main(String[] args) {
        Hello.getOne().sayHello();
    }

}
