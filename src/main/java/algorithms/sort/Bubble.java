package algorithms.sort;

/**
 * 不断交换把最大的元素放到最后，
 * 如果有一次遍历所有元素没有发生交换，代表已经有序了
 * Created by liuwei on 2020/4/3
 */
public class Bubble extends BaseSort{

    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            boolean flag= true;
            for (int j = 0; j < length  - i - 1; j ++) {
                if (less(array[j + 1], array[j])) {
                    exec(array, j , j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        Integer[] array = {10, 30, 3, 99, 56, 2, 45, 33, 10, 5, 4, 1};
        new Bubble().sort(array);
        show(array);
        System.out.println(isSorted(array));
    }

}
