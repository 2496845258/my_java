package 修改流元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 流元素拼接 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(Arrays.asList("A B C D E".split(" ")));

        //collect()会根据参数将所以流元素组合。
        String str = arrayList.stream().collect( Collectors.joining("+") ).toString();  //joining得到一个String
        System.out.println(str);

        String[] str2 = { "123", new String("456")};
    }

}
