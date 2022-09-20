package 终结操作;

import java.util.Optional;

public class 创建Optional {
    public static void main(String[] args) {
        //返回一个空的Optional
        System.out.println(Optional.empty());

        //存对象
        System.out.println( Optional.of("123") );

        //存对象(推荐)
        System.out.println( Optional.ofNullable( null ) ); //如果对象为null,则返回空的Optional

        //筛选
        System.out.println(Optional.ofNullable("456").filter(i -> {
            boolean flag = false;
            if (!i.equals("null")) {
                flag = true;
            }
            return flag;
        })); //如果为false 则返回empty

        //也有map和flatMap
    }
}
