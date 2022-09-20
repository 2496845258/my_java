package 修改流元素;

import java.util.Arrays;

public class 对流中元素进行排序 {
    public static void main(String[] args) {
        var arr = new User[5];
        for (var i = 0; i < arr.length; i++) {
            arr[i] = new User();
            arr[i].a = i;

        }
        Arrays.asList(arr).sort( (i, j)->{
            return -1;
        });

        //sort 方法接收一个2参1返回的方法，这个返回的取值为 -1 0 1, 分别表示 > = <。两个对象相互比较
        Arrays.stream(arr).sorted( (i,j)->{
            return 1;
        }).forEach( i-> System.out.println(i.a));
    }
}
