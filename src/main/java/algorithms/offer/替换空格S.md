# 5. 替换空格

## 题目链接

[牛客网](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github)

## 题目描述

将一个字符串中的空格替换成 "%20"。

```text
Input:
"We are happy"

Output:
"We%20are%20happy"
```

## 解题思路

#### a. 调用String的API，比如replaceAll方法。

#### b. 从第一个元素开始找到空格，插入元素，把后面的元素往后面移动

#### c. 双指针

① 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），所以当遍历到一个空格时，需要在尾部填充两个任意字符。

② 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。

③ 当 P2 遇到 P1 时（P2 <= P1），或者遍历结束（P1 < 0），退出。

```java
public String replaceSpace(StringBuffer str) {
    int length = str.length();
    //统计空格的数量
    int blankCount = 0;
    for (int i = 0; i < length; i++) {
        if (str.charAt(i) == ' ') {
            blankCount++;
        }
    }
    //扩展字符串的长度
    int newLength = length + 2 * blankCount;
    str.setLength(newLength);
    //用两个指针开始往前循环，一个指向原数组的末尾，一个指向扩展后数组的末尾,向前移动
    int first = length - 1;
    int last = newLength - 1;
    while(first >=0 || last < first) {
        char temp = str.charAt(first--);
        if (temp == ' ') {
            str.setCharAt(last--, '0');
            str.setCharAt(last--, '2');
            str.setCharAt(last--, '%');
        } else {
            //插入first位置的值
            str.setCharAt(last--, temp);
        }
    }
    return str.toString();
}
```