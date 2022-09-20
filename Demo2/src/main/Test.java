package main;

public class Test {
    static int n = 16;
    static char[] arr = new char[n];
    static int index = 0;
    public static void main(String[] args) {
        System.out.println(add("hello"));
        System.out.println(add("world"));
    }

    public static String add(String str) {

        while( arr.length < str.length() ) {
            n = n * 2 + 2;
            arr = new char[n];
        }
        //拼接
        var i = 0;
        for( i = index; i < index + str.length(); i++ ) {
            arr[i] = str.charAt(i-index);
        }
        index = i--;

        return new String(arr);
    }
}
