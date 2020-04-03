package algorithms.sort;

/**
 * Created by liuwei on 2020/4/2
 */
public abstract class BaseSort {

    protected abstract void sort(Comparable[] array);

    protected static void exec(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    protected static void show(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected static boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
