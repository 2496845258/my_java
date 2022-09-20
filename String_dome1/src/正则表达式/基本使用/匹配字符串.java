package 正则表达式.基本使用;

public class 匹配字符串 {
    public static void main(String[] args) {

        //正则表达式很简单，就前面是内容，后面是次数
        // () 表示整体，[] 表示里面的内容为或也就是出现的内容
        System.out.println( "abcabc".matches("(abc){2}"));

        //以什么开头
        System.out.println( "abcccc".matches("(abc).*"));

        //包含
        System.out.println( "aaabcccc".matches(".*(abc).*"));

        //以什么结尾
        System.out.println( "aaaabc".matches(".*(abc)"));


        //? 表示1或0。在\w 表示字26个字母，\W 表示非26个字母 +表示1或多
        System.out.println( "abc".matches( "a?\\w+" ) );

        System.out.println("\\".matches("\\\\"));

        // \\\\ 表示2个\\  匹配4个\  就得8个 \。这么蠢的设计是因为java一开始没考虑正则表达式
        System.out.println("\\\\");
        System.out.println( "\\\\".matches("\\\\\\\\"));
    }
}
