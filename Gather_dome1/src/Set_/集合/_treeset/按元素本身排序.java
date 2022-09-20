package Set_.集合._treeset;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class 按元素本身排序 {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();
        Collections.addAll( treeSet, "C B A world1".split(" "));
        System.out.println(treeSet);
    }
}
