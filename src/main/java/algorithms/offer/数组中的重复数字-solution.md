# 1. 数组中重复的数字

## 题目链接
[牛客网](https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github)

## 题目描述
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 
例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

## 解题思路

### 1. 粗暴解法：两层循环遍历找到重复的数

### 2. 使用哈希表--HashSet
时间复杂度 O(n)

空间复杂度 O(n)

或者用数组标记，具体的位置存1

### 3. 先排序再比较
先使用快速排序排序，如果相邻的元素相等则存在重复的元素 

时间复杂度 O(nlogn)

### 4. 时间复杂度为O(n)
 
要求时间复杂度 O(N)，空间复杂度
O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。

对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。

以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复：

```java
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
```