# 4. 二维数组中的查找

## 题目链接

[牛客网](https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github)

## 题目描述

给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。

```html
Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.
Given target = 20, return false.
```

## 解题思路

暴力解法：遍历二维数组中所有的数（时间复杂度O(N^2))

思想：从左下角或者右上角开始查找，就可以不断缩小数组的查找区间(时间复杂度O(M+N))

```java
public boolean find(int target, int [][] array) {
    //行的长度
    int rowLength = array.length;
    //列的长度
    int columnLength = array[0].length;
    int i = rowLength - 1;
    int j = 0;
    //从左下角开始查找
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
```