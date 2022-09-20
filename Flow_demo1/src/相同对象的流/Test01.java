package 相同对象的流;

import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        //基本用法
        Stream.generate( () -> new String("Hello") ).limit(3).forEach(System.out::println);

        //用流来使用静态工厂方法
        Stream.generate( Test01::getTest ).limit(3).forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Test01";
    }

    static Test01 getTest() {
        return new Test01();
    }
}
