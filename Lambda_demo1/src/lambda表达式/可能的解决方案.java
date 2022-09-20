package lambda表达式;

public class 可能的解决方案 {
    public static void main(String[] args) {
        //其实，这样理解，为了作为匿名类的一种解决方案。
        //有的时候我们写匿名类，只是为了实现接口，并使用功能，并不打算复用这段代码。如果要复用还是老老实实使用定义接口实现
        //比如
        new Thread(new Runnable() {
            @Override
            public void run() {
                //很多时候我们用线程，也就是用里面的run函数
                System.out.println("使用匿名类中的方法");
            }
        }).start();

        //那如果我们用lambda表达式
        //首先我们得知道Runnable接口必须实现的方法只有一个，并且无参，无返回的方法。
        new Thread( () -> {
            System.out.println("使用lambda表达式");
        }).start();
        //注意，因为Runnable接口可以使用这个表达式是因为结构相似。
        // 可以把这个lambda表达式理解为，这是个实现接口的匿名类的简单写法。因为实现接口得实现抽象方法所以给出方法的实现
        // 那么反正是匿名类了，就不省略不写了，只需要提供方法的实现就行。(可以这么理解)
        // 最后我是这么理解的，反正实现接口其实最终是为了实现抽象方法，lambda表达式只是让这个实现的过程更加简单。

    }
}
