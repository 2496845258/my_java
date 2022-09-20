package main2;

public class Fu {
    public static String str2 = "777";


    {
        System.out.println("Fu类正在被实例化");
        show();
    }
    private int a = 1;
    public void show(){
        System.out.println(this.a);
    }
}
