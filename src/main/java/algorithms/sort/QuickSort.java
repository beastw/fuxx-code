package algorithms.sort;

/**
 * 确定一个数，然后确定这个数的位置，小的放一边，大的放一边
 * 递归
 * Created by liuwei on 2020/4/3
 */
public class QuickSort extends BaseSort {

    @Override
    public void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int left, int right) {
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
        sort(array, left, hi - 1);
        sort(array, hi + 1, right);
    }

    public static void main(String[] args) {
        Integer[] array = {10, 30, 3, 99, 56, 2, 45, 33, 10, 5, 4, 1};
        new QuickSort().sort(array);
        show(array);
        System.out.println(isSorted(array));
    }

}
