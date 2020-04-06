package algorithms.offer;

/**
 * Created by liuwei on 2020/4/6
 */
public class 二维数组中的查找 {

    /**
     * 暴力解法：遍历所有的元素
     * 其他解法：从左下角和右上角开始比较
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int [][] array) {
        //行的长度
        int rowLength = array.length;
        //列的长度
        int columnLength = array[0].length;
        for (int i = rowLength - 1; i >= 0; i--) {
            for (int j = 0; j < columnLength; j++) {
                if (target > array[i][j]) {
                    continue;
                } else if (target < array[i][j]) {
                    break;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find02(int target, int [][] array) {
        //行的长度
        int rowLength = array.length;
        //列的长度
        int columnLength = array[0].length;
        int i = rowLength - 1;
        int j = 0;
        while (i >= 0 && j < columnLength) {
            if (target > array[i][j]) {
                j++;
            } else if (target < array[i][j]){
                i--;
            } else {
                return true;
            }
        }
        return false;
    }

}
