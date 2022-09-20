package 枚举;

public class 代替接口中常量 {
    private static enum Xxx {
        ONE(1, "hello");
        private final int i;
        private final String hello;
        Xxx(int i, String hello) {
            this.i = i;
            this.hello = hello;
        }
    }
    private static enum Xxx2{
        VVV(2);

        private final int i;
        Xxx2(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }
    }

    public static void main(String[] args) {
        System.out.println(Xxx.ONE.i);
        System.out.println(Xxx2.VVV.getI());
    }
}
