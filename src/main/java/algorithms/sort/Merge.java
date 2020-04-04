package algorithms.sort;

/**
 * Created by liuwei on 2020/4/4
 */
public class Merge extends BaseSort {

    @Override
    protected void sort(Comparable[] array) {
        //
        Comparable[] aux = new Comparable[array.length];
        sort(array, aux, 0, array.length - 1);
    }

    private void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int  mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        for (int l = lo; l <= hi; l++) {
            if (i > mid) {
                array[l] = aux[j++];
            } else if (j > hi) {
                array[l] = aux[i++];
            } else if(less(aux[j], aux[i])) {
                array[l] = aux[j++];
            } else {
                array[l] = aux[i++];
            }
        }
    }

    //先实现两个有序数组合并成一个有序数组
    private static void mergeSortedArray(Comparable[] a, Comparable[] b) {
        // 每个数组一个指针，然后往后面移
        // 还需要一个辅助数组
        int aLength = a.length;
        int bLength = b.length;
        Comparable[] finalArray = new Comparable[aLength + bLength];

        int aIndex = 0;
        int bIndex = 0;
        int fIndex = 0;

        while (aIndex < aLength && bIndex < bLength) {
                if (less(b[bIndex], a[aIndex])) {
                    finalArray[fIndex] = b[bIndex];
                    bIndex++;
                } else {
                    finalArray[fIndex] = a[aIndex];
                    aIndex++;
                }
            fIndex++;
        }

        //然后哪个数组还有剩余，继续把数据移动进去
        while (aIndex < aLength) {
            finalArray[fIndex] = a[aIndex];
            aIndex++;
            fIndex++;
        }

        while (bIndex < bLength) {
            finalArray[fIndex] = b[bIndex];
            bIndex++;
            fIndex++;
        }

        show(finalArray);
    }

    public static void down2UpMergeSort(Comparable[] array) {
        int length = array.length;
        Comparable[] temp = new Comparable[length];
        for (int sz = 1; sz < length; sz += sz) {
            for (int lo = 0; lo < length - sz; lo += sz + sz) {
                merge(array, temp, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, length - 1));
            }
        }
    }


    public static void main(String[] args) {
        Integer[] b = {2, 5, 6, 9, 1, 2, 4, 7, 8, 11};
        new Shell().sort(b);
        show(b);
    }
}
