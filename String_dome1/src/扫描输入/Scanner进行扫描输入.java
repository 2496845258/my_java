package 扫描输入;

import java.util.Scanner;

public class Scanner进行扫描输入 {
    public static void main(String[] args) {
        //java 5引入Scanner

        Scanner in = new Scanner("hello world 11 0.18");
        System.out.println(in.nextLine());


        //自定义分割符号，用正则
        in = new Scanner("hello*world|11");
        in.useDelimiter("\\*|\\|"); //正则表达式中|表示或 [\\*\\|]这个里面是包含也是或的意思
        System.out.println(in.next());
        System.out.println(in.next());
        System.out.println(in.nextInt());

        //自定义分隔符
        String str = "aaa #{123},#{456}";
        Scanner in2 = new Scanner(str);

        //这是定义分隔符（把,号也当作分隔符）
        in2.useDelimiter("[ ,\n]");
        while( in2.hasNext() ) {
            String x = in2.next();
            //这样来匹配输入的内容是不是想要的
            if( x.matches("#\\{.+\\}") ) {
                System.out.println(x.substring(2, x.length()-1).trim());
            }
        }


    }
}
