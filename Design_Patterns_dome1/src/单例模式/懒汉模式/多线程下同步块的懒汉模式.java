package 单例模式.懒汉模式;

public class 多线程下同步块的懒汉模式 {
    private static class Hello {
        private static Hello hello;
        private Hello() {

        }
        public static Hello getInstance() {
            if ( null == hello) {
                synchronized ( Hello.class ) {
                    if ( null == hello ) {
                        hello = new Hello();
                    }
                }
            }
            return hello;
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println( Hello.getInstance());
        }).start();
        new Thread(()->{
            System.out.println( Hello.getInstance());
        }).start();
    }
}
