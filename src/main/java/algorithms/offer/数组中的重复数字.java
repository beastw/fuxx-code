package algorithms.offer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Created by liuwei on 2020/4/5
 */
public class 数组中的重复数字 {

    /**
     * 两次循环遍历 时间复杂度O(n^2)
     */
    public boolean solution01(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] == numbers[j]) {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }


    public boolean solution(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        int[] check = new int[length];
        for (int i = 0; i < length; i++) {
            if (check[numbers[i]] == 1) {
                duplication[0] = numbers[i];
                return true;
            }
            check[numbers[i]] = 1;
        }
        return false;
    }

    /**
     * 使用哈希表--hashset 时间复杂度 O(n) 空间复杂度 O(n)
     */
    public boolean solution02(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        //通过HashSet
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                //放入duplication中,duplication进行初始化
                duplication = new int[1];
                duplication[0] = numbers[i];
                return true;
            } else {
                set.add(numbers[i]);
            }
        }
        return false;
    }

    /**
     * 先排序，然后相邻的相等则存在重复元素 排序可以选用快速排序 时间复杂度：O(nlogn)
     */
    public boolean solution03(int numbers[], int length, int[] duplication) {
        //快速排序的思想,需要先把顺序打乱
        quickSort(numbers, 0, length - 1);
        for (int i = 0; i < length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication = new int[1];
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    private static void quickSort(int[] numbers, int left, int right) {
        if (left > right) {
            return;
        }
        int j = partition(numbers, left, right);
        quickSort(numbers, left, j - 1);
        quickSort(numbers, j + 1, right);
    }

    private static int partition(int[] numbers, int left, int right) {
        int lo = left;
        int hi = right;
        int v = numbers[left];
        while (lo <= hi) {
            while (hi != left && v < numbers[hi]) {
                hi--;
            }
            while (lo != right && v > numbers[lo]) {
                lo++;
            }
            if (lo < hi) {
                swap(numbers, hi, lo);
            } else {
                break;
            }
        }
        swap(numbers, hi, left);
        return hi;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 对于数组元素在[0, n-1]范围内的问题，可以将值为i的元素调整到第i个位置上。
     * 如果第i位置上已经有一个为i的元素，就可以知道i值重复
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean solution04(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }
}