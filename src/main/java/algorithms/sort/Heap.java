package algorithms.sort;

/**
 * Created by liuwei on 2020/4/4
 */
public class Heap extends BaseSort {

    @Override
    protected void sort(Comparable[] array) {
        int length = array.length;
        //已知子节点求父节点  k/2 - 1
        for (int k = (length - 1 ) / 2 ; k >= 0; k--) {
            sink(array, k, length);
        }
        for (int j = length - 1; j > 0; j--) {
            exec(array, 0, j);
            sink(array, 0, j);
        }
    }

    /**
     * 上浮 在堆中当一个节点比父节点大的时候，需要交换这两个节点，交换后可能比 它新的父节点大，
     * 因为需要不断进行比较和交换操作。这种操作称为上浮
     * 已知子节点求父节点  (k - 1)/2
     */
    private static void swim(Comparable[] array, int k) {
        while (k > 0 && less(array[k - 1 / 2], array[k])) {
            exec(array, k - 1 / 2, k);
            k = k - 1 / 2;
        }
    }

    private static void sink(Comparable[] array, int k, int length) {
        //k为下沉的数，length为数组对的长度
        //index为0的时候，左子节点为2*k + 1
        while (2 * k + 1 < length) {
            int leftChild = 2 * k + 1;
            //判断左右节点哪个比较大
            if (leftChild + 1 <= length - 1 && less(array[leftChild], array[leftChild + 1])) {
                leftChild++;
            }
            //如果节点不比子节点大的小直接退出
            if (!less(array[k], array[leftChild])) {
                break;
            }
            //交换父节点与较大子节点的位置
            exec(array, leftChild, k);
            //继续下沉交换的节点
            k = leftChild;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {10, 30, 3, 99, 56, 2, 45, 33, 10, 5, 4, 1};
        new Heap().sort(array);
        show(array);
        System.out.println(isSorted(array));
    }
}
