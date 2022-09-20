package 继承的问题.破环封装;

public class Fu {
    private int sum = 0;
    public void sum(Integer... arr) {
        for ( var i : arr ) {
            sum += i;
        }
    }

    public void clear() {
        sum = 0;
    }

    public int getSum() {
        return this.sum;
    }

    public static void main(String[] args) {
        var f = new Fu();
        f.sum(1, 2, 3);
        f.clear();
        f.sum(4,5,6);
        System.out.println( f.getSum());
    }
}
