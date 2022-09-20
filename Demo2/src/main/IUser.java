package main;

public interface IUser {
    default public void sayHello() {
        System.out.println("我是接口的默认实现");
    }

}
