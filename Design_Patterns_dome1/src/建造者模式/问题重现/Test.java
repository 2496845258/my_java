package 建造者模式.问题重现;

import 建造者模式.问题重现.pojo.Man;
import 建造者模式.问题重现.pojo.Woman;

public class Test {
    public static void main(String[] args) {
        //创造一个男人
        Man man = new Man();
        man.setName("张三");
        man.setHeight(175);
        man.setWeight(120);


        //使用一个男人
        System.out.println(man.toString());

        //创建一个女人
        Woman woman = new Woman();
        woman.setName("李四");
        woman.setHeight(165);
        woman.setWeight(95);

        //使用一个女人
        System.out.println(woman.toString());

        //我们发现一个问题，虽然两个类不同，但是这两个类的构造过程是相同的。
        //这里构造的过程我进行了简化，别忘了参数的传入还需要验证的。还有参数本身也可能和别人产生关系

        //那我把相同的构造过程抽取成方法。虽然他们是不同的类，构造过程相同，且复杂。
        //我们再把这两个类的构造过程进行标准化，如果以后，有哪个类跟这两个类的构造过程相关，我只需要继承即可

    }
}
