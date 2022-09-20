package 自定义异常类;

public class Test {
    public static void main(String[] args) {
        try {
            xxx();
        } catch (MyException e) {
            //为什么不直接在原来的方法中处理错误情况而抛出异常
            //因为我不可能考虑到所有情况我只关注我的业务，你给我的输入有问题其实应当你来处理，而不是写一个万能程序。这也不可能
            System.out.println("异常被捕获");
            e.printStackTrace(System.err); //将调试信息打印到标准错误流
        }
    }
    public static void xxx() throws MyException {
        throw new MyException();
    }
}
class MyException extends Exception {
    //自定义了一个异常类
    //因为是继承了原有的异常类，所以方法都存在没重写
    MyException() {
        //大部分情况都使用无参构造，只要你的异常类名能见名知意
    }
    MyException( String str ) {
        super(str);
        //显然咱们这个异常类就不够见名知意，所以需要一个string的有参构造来存储异常的信息
    }
}
