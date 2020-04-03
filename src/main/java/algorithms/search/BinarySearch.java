package algorithms.search;

/**
 * 有序数组的二分查找
 * Created by liuwei on 2020/4/1
 */
public class BinarySearch {

    /**
     * -1代表查找不到，迭代
     */
    public static int search1(int value, int[] sortedArray) {
        if (sortedArray.length == 0) {
            return -1;
        }
        int low = 0;
        int high = sortedArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value < sortedArray[mid]) {
                //查找左边
                high = mid - 1;
            } else if (value > sortedArray[mid]) {
                //查找右边
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归查找， -1代表查找不到
     * @param value
     * @param sortedArray
     * @return
     */
    public static int search2(int value, int[] sortedArray) {
        if (sortedArray.length == 0) {
            return -1;
        }
        int low = 0;
        int high = sortedArray.length - 1;
        int mid = (low + high) / 2;
        if (value < sortedArray[mid]) {
            int[] newArray = new int[mid - low];
            System.arraycopy(sortedArray, 0, newArray, 0, mid - low);
            return search2(value, newArray);
        } else if (value > sortedArray[mid]) {
            int[] newArray = new int[high - mid];
            System.arraycopy(sortedArray, mid + 1, newArray, 0, high - mid);
            return search2(value, newArray);
        } else {
            return mid;
        }
    }

    /**
     * 递归查找，-1表示查找不到
     * @param value
     * @param sortedArray
     * @param low
     * @param high
     * @return
     */
    public static int search3(int value, int[] sortedArray, int low, int high) {
        if (sortedArray.length == 0) {
            return -1;
        }
        if (low > high) {
            return -1;
        }
        int mid = (high + low) / 2;
        if (value < sortedArray[mid]) {
            return search3(value, sortedArray, low, mid - 1);
        } else if (value > sortedArray[mid]) {
            return search3(value, sortedArray, mid + 1, high);
        } else {
            return mid;
        }
    }
}
