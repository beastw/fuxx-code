package algorithms.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 确定一个数，然后确定这个数的位置，小的放一边，大的放一边
 * 递归
 * Created by liuwei on 2020/4/3
 */
public class QuickSort extends BaseSort {

    @Override
    public void sort(Comparable[] array) {
        shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable[] array, int left, int right) {
        if (right <= left) {
            return ;
        }
        int j = partition(array, left, right);
        sort(array, left, j-1);
        sort(array, j + 1, right);
    }

    //打乱顺序
    private static void shuffle(Comparable[] array) {
        List<Comparable> comparables = Arrays.asList(array);
        Collections.shuffle(comparables);
        comparables.toArray(array);
    }

    private static int partition(Comparable[] array, int left, int right) {
        int i = left;
        int j = right;
        Comparable v = array[left];
        while (true) {
            while (less(array[++i], v) && i != right) ;
            while (less(v, array[--j]) && j != left) ;
            if (i >= j) {
                break;
            }
            exec(array, i, j);
        }
        exec(array, left, j);
        return j;
    }

    private static void sort1(Comparable[] array, int left, int right) {
        //以左边第一个数作为分割数
        int lo = left;
        int hi = right;
        while (lo < hi) {
            while (less(array[lo], array[left])) {
                lo ++;
            }
            while (less(array[left], array[hi])) {
                hi --;
            }
            if (lo < hi) {
                exec(array, lo, hi);
            }
        }
        exec(array, left, hi);
        sort1(array, left, hi - 1);
        sort1(array, hi + 1, right);
    }

    public static Comparable select(Comparable[] array, int k) {
        int l = 0;
        int h = array.length - 1;
        while (h > l) {
            int j = partition(array, l, h);
            if (j == k) {
                return array[k];
            } else if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return array[k];
    }


    public static void main(String[] args) {
        Integer[] array = {10, 30, 3, 99, 56, 2, 45, 33, 10, 5, 4, 1};
        new QuickSort().sort(array);
        show(array);
        System.out.println(isSorted(array));
    }

}
