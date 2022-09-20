package Set_.集合._linkedhashset;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class 按插入顺序去重 {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Collections.addAll( linkedHashSet, "C B A hello1".split(" "));
        System.out.println(linkedHashSet);

    }
}
