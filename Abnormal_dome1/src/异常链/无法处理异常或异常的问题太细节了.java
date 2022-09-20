package 异常链;

public class 无法处理异常或异常的问题太细节了 {
    private static class MyException extends Exception {
        public MyException(String msg, Throwable cause) {
            super(msg, cause);
            // 次构造方法用于传递异常，且提供额外信息
        }

        public MyException(Throwable cause) {
            super(cause);
            //这两个构造方法都用于形成异常链
        }

        public MyException() {
            super();
        }

        public MyException(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) {
        try {
            chufa(4,0);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println("输入错误数字");
        }
    }

    public static int chufa(int a, int b) throws MyException {
        try {
            return a/b;
        } catch ( Exception e ) {
            throw new MyException("算术运算失败", e);
        }
    }
}
