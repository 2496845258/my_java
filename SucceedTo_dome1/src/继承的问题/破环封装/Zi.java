package 继承的问题.破环封装;

public class Zi extends Fu{
    private int sum = 0;

    @Override
    public void sum(Integer... arr) {
        for ( var i : arr ) {
            sum += i > 3?0:i;
        }
    }


    public static void main(String[] args) {
        var z = new Zi();
        z.sum( 1,2,3,4);
        System.out.println(z.getSum());
        z.clear();
        z.sum( 1, 1, 1);
        System.out.println(z.getSum());
    }
}
