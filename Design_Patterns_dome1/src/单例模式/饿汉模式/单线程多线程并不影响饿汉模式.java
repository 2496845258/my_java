package 单例模式.饿汉模式;

public class 单线程多线程并不影响饿汉模式 {
    private static class Hello {
        private static Hello hello = new Hello();
        private Hello() {}
        public static Hello getInstance() {
            return hello;
        }

    }
}
