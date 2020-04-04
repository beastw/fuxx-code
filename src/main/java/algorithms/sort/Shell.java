package algorithms.sort;

/**
 * 每次对相隔h的数组插入排序，最后对整个数组进行排序
 * Created by liuwei on 2020/4/3
 */
public class Shell extends BaseSort {

    @Override
    protected void sort(Comparable[] array) {
        int length = array.length;
        int gap = 1;// 1、4、 13、 40、121、......
        while(gap < length/3) {
            gap = 3 * gap + 1;
        }
        while (gap >= 1) {
            //i++是因为每个元素都需要和gap之后的数据比较
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && less(array[j], array[j - gap]); j -= gap) {
                    exec(array, j, j - gap);
                }
            }
            gap /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {10, 30, 3, 99, 56, 2, 45, 33, 10, 5, 4, 1};
        new Shell().sort(array);
        show(array);
        System.out.println(isSorted(array));
    }
}
