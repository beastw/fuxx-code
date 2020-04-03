package algorithms.sort;

/**
 * 从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
 *
 * 比较次数：(N-1)+(N-2)+...+2+1=N(N-1)/2~N^2/2,它的运行时间与输入无关，这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
 * 交换次数：如果自身也交换需要N次
 * Created by liuwei on 2020/4/2
 */
public class Selection extends BaseSort {

    @Override
    public void sort(Comparable[] array) {

        int length = array.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            if (i != min) {
                exec(array, i, min);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {10, 30, 3, 99, 56, 2, 45, 33, 10, 5, 4, 1};
        new Selection().sort(array);
        show(array);
        System.out.println(isSorted(array));
    }

}
