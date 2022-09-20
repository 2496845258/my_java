package 建造者模式.解决方案;

/**
 * 为流程的构造过程定一个规范
 * 定义了一个人类构造接口，规定了一套构造流程
 */
public interface MankindBuild {
    /**
     * 下面三个方法为具体的创建方法
     */
    void setName();
    void setHeight();
    void setWeight();

    /**
     * 最为重要的方法，获取按流程创建好的对象
     * @return
     */
    IMankind getMankind();
}
