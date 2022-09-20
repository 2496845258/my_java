package 建造者模式.解决方案;

public class WomanBuild implements MankindBuild{
    /**
     * 我是女人创建者，我就声明我要按流程创建一个女人
     */
    private Woman woman;
    public WomanBuild() {
        woman = new Woman();
    }

    @Override
    public void setName() {
        woman.setName("小红");
    }

    @Override
    public void setHeight() {
        woman.setHeight(165);
    }

    @Override
    public void setWeight() {
        woman.setWeight(95);
    }

    @Override
    public IMankind getMankind() {
        return woman;
    }
}
