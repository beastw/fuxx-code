package algorithms.sort;

/**
 * Created by liuwei on 2020/4/4
 */
public class ThreeWayQuick extends BaseSort{

    @Override
    protected void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int lo = left;
        int i = left + 1;
        int hi = right;
        Comparable v= array[left];
        while (i <= hi) {
            int cmp = array[i].compareTo(v);
            if (cmp > 0) {
                exec(array, i, hi);
                hi--;
            } else if (cmp < 0) {
                exec(array, lo, i);
                i++;
                lo++;
            } else {
                i++;
            }
        }
        sort(array, left, lo - 1);
        sort(array, hi + 1, right);
    }

    public static void main(String[] args) {
        Integer[] array = {10, 30, 3, 99, 56, 2, 45, 33, 10, 5, 4, 1};
        new ThreeWayQuick().sort(array);
        show(array);
        System.out.println(isSorted(array));
    }
}
