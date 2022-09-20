package 建造者模式.解决方案;

/**
 * 为每个需要复杂的构建的类并且满足一定构造流程创建一个实现类
 */
public class ManBuild implements MankindBuild{

    /**
     * 我是男人的建造者，我就负责按流程创建男人
     */
    private Man man;
    public ManBuild() {
        man = new Man();
    }
    public ManBuild(Man man) {
        this.man = man;
    }

    @Override
    public void setName() {
        man.setName("张三");
    }

    @Override
    public void setHeight() {
        man.setHeight(175);
    }

    @Override
    public void setWeight() {
        man.setWeight(120);
    }

    @Override
    public IMankind getMankind() {
        return man;
    }
}
