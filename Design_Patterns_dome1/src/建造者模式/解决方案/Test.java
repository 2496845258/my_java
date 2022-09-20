package 建造者模式.解决方案;

public class Test {
    public static void main(String[] args) {
        //我需要一个导演
        MankindDirector director = new MankindDirector();

        //需要具体的创建者，我想要男人，我就创建一个男人的创建者
        ManBuild manBuild = new ManBuild();

        //为导演设置创建者
        director.setMankindBuild(manBuild);

        //从导演获取按流程创建好的男人
        IMankind man = director.direct();
        //使用男人
        man.show();

        //那我想要女人了，同样的流程
        WomanBuild womanBuild = new WomanBuild();
        director.setMankindBuild(womanBuild);
        IMankind woman = director.direct();

        //使用女人
        woman.show();
    }
}
