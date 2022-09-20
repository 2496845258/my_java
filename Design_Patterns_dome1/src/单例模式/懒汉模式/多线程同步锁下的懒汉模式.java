package 单例模式.懒汉模式;

public class 多线程同步锁下的懒汉模式 {
    private static class Hello {
        private static Hello hello;
        private Hello() {

        }
        public synchronized static Hello getInstance() {
            //如此确实保证了，即使是在多线程环境下也不会产生多个实例了，但是新的问题来了
            //我们用单例模式的时候大多数情况下只是为了那句return hello;
            //这样看无论三七二十一直接一刀切，合适吗
            //这个锁只是为了if 里面的冲突。所以我们应该改进这个锁的位置，应该锁代码块。而不是方法
            if ( null == hello ) {
                hello = new Hello();
            }
            return hello;
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Hello.getInstance());
        }).start();
        new Thread(()->{
            System.out.println(Hello.getInstance());
        }).start();
    }
}
