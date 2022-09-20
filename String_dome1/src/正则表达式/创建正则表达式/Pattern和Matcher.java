package 正则表达式.创建正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern和Matcher {
    public static void main(String[] args) {
        //需要使用正则表达式来操作字符串的时候，一般都是编译正则表达式对象，String本身自带的功能用来做匹配格式还可以

        //生成正则表达式对象
        Pattern pattern = Pattern.compile("\\d+abc");

        //传入被待匹配的字符串生成操作对象
        Matcher matcher = pattern.matcher("3abc 4abc");

        //进行匹配。find() 方法相当于迭代器，会返回下一个还有没有
        while ( matcher.find() ) {
            //获取一个符合的匹配
            System.out.print( matcher.group() + " ");
            System.out.println( "位置：" + matcher.start() +  " " + (matcher.end()-1));
        }

        //匹配相同的快捷方法
        System.out.println(Pattern.matches ("\\d*abc", "abc"));


    }
}
