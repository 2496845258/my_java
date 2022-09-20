package 建造者模式.解决方案;

public class Woman implements IMankind {
    private String name;
    private Integer height;
    private Integer weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }


    @Override
    public void show() {
        System.out.println( name + "的身高为=" + height + " 体重为=" +  weight);
    }
}
