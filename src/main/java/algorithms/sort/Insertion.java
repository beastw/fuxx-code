package algorithms.sort;

/**
 * 插入排序，把数组前面的不断当做有序的，然后把后面的元素一个一个移动到指定位置
 * Created by liuwei on 2020/4/3
 */
public class Insertion extends BaseSort {

    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i ; j > 0 && less(array[j], array[j-1]); j--) {
               exec(array, j , j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {10, 30, 3, 99, 56, 2, 45, 33, 10, 5, 4, 1};
        new Insertion().sort(array);
        show(array);
        System.out.println(isSorted(array));
    }

}
