package 数组流;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        //double数组流
        Arrays.stream(new double[]{ 0.1234, 0.5678 }).forEach( i -> System.out.print( i + " "));
        System.out.println();
        Arrays.stream(new double[]{ 0.1234, 0.5678 }).forEach( i -> System.out.format("%.2f ", i));

        //int数组流...Long数组流....都一样


    }
}
