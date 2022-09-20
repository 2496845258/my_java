package 编译器检测类型转换;

import java.lang.reflect.Array;
import java.util.Iterator;

public class DongtaiArray<T> implements Iterable<T>{
    private int index = 0; //下一个操作的位置
    private int max = 16;
    private Object[] arrs = new Object[max];

    public DongtaiArray() {
    }

    public int size() {
        return index;
    }

    public <T> T get(int i) {
        return (T)arrs[i];
    }


    public void add(T t) {
        if ( index >= max - 1 ) {
            kuorong();
        }
        arrs[index++] = t;
    }

    public T remove() {
        T t = null;
        if ( index >= 1 ) {
            t = (T) arrs[--index];
//            arrs[index + 1] = null;
        }
        return t;
    }

    private void kuorong() {
        max = max * 2 + 1;
        var arr = new Object[max];
        for( var i = 0; i <= index; i++ ) {
            arr[i] = arrs[i];
        }
        arrs = arr;
    }

    public void pinjie( DongtaiArray<?> darr) { //这个泛型表示，父类
        if ( index + darr.size() >= arrs.length - 1 ) {
            kuorong();
        }

        for( var i = 0; i < darr.size(); i++ ) {
            arrs[index++] = darr.get(i);
        }
    }

    public T[] toArray(Class<T> tClass) {
        var copy = Array.newInstance(tClass, index);
        //复制一下数组里面的内容到另一个数组, 原一个数组的开始位置, 目标数组的开始位置，复制的个数
        System.arraycopy(arrs, 0, copy, 0, index);
        return (T[]) copy;
    }


    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int i = 0;
            @Override
            public boolean hasNext() {
                return i < index;
            }

            @Override
            public T next() {
                return (T)arrs[i++];
            }
        };
    }
}
