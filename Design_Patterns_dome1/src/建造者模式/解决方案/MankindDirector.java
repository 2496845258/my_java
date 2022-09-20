package 建造者模式.解决方案;

public class MankindDirector {
    private MankindBuild mankindBuild;

    /**
     * 为导演类设置不同的建造者
     * @param mankindBuild
     */
    public void setMankindBuild(MankindBuild mankindBuild) {
        this.mankindBuild = mankindBuild;
    }

    /**
     * 开始按流程建造
     * @return
     */
    public IMankind direct() {
        //开始为人类设置名字，身高，体重
        mankindBuild.setName();
        mankindBuild.setHeight();
        mankindBuild.setWeight();

        //返回创建好的人类。具体创建了什么人类，由设置进来的建造者的类型来决定
        return mankindBuild.getMankind();
    }
}
