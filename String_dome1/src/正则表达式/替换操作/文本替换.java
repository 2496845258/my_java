package 正则表达式.替换操作;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 文本替换 {
    public static void main(String[] args) {

        String str = "abc adc ababa";
        var m = Pattern.compile("ab\\w{1,3}").matcher(str);

        //替换第一个成功的匹配.{}限制字符次数
        System.out.println( m.replaceFirst("ABC")); //给出替换后的字符串

        //替换全部匹配
        System.out.println( m.replaceAll("AAA"));

        //匹配部分呢？
//        m.appendReplacement() p580

        //想换新的操作字符串对象了
        m.reset("aaa aaa bbb bbb");


    }
}
