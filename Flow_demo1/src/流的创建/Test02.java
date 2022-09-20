package 流的创建;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class Test02 {
    public static void main(String[] args) throws Exception {
        //eclipse中./就是源文件的位置，而idea./是项目的位置
        List<String> lines = Files.readAllLines(Paths.get("./Flow_demo1/src/a.txt") );

        //subList(n,m);用于对list进行切片
        for ( var i : lines.subList(0, lines.size() ) ) {
            System.out.println(i);
        }

        range(0, lines.subList(1, lines.size()).size() ).forEach( i -> System.out.println(lines.get(i)));

        lines.subList(1, lines.size()).stream().forEach(System.out::println);

        //将流中的字符串拼接在一起
        String s = lines.subList(1, lines.size()).stream().collect(Collectors.joining(" "));
        System.out.println(s);




        //方法2
        System.out.println("方法2");
        //读取文件流，skip()跳过指定数目
        Files.lines(Paths.get("./Flow_demo1/src/a.txt") ).skip(1)
                .forEach( line -> {
                    //流里面用流
                    Arrays.stream(line.split(" ")).forEach(System.out::println);
                });

    }

}
