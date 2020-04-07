# 6.从尾到头打印链表

## 题目链接

[牛客网](https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github)

## 题目描述

从尾到头反过来打印出每个结点的值。

## 解题思路

### 1. 借用栈的先进后出，遍历链表

```java
public ArrayList<Integer> printListFromTailToHead02(ListNode listNode) {
    Stack<Integer> stack = new Stack<>();
    while (listNode != null) {
        stack.push(listNode.val);
        listNode = listNode.next;
    }
    ArrayList<Integer> result = new ArrayList<>();
    while (stack.size() > 0) {
        result.add(stack.pop());
    }
    return result;
}
```

### 2. 将链表反转再遍历

```java
public ArrayList<Integer> printListFromTailToHead03(ListNode listNode) {
    ListNode reverseList = null;
    while (listNode != null) {
        ListNode temp = listNode.next;
        listNode.next = reverseList;
        reverseList = listNode;
        listNode = temp;
    }
    ArrayList<Integer> result = new ArrayList<>();
    while (reverseList != null) {
        result.add(reverseList.val);
        reverseList = reverseList.next;
    }
    return result;
}
```

### 3. 递归打印

```java
public ArrayList<Integer> printListFromTailToHead01(ListNode listNode) {
    ArrayList<Integer> result = new ArrayList<>();
    if (listNode != null) {
        result.addAll(printListFromTailToHead01(listNode.next));
        result.add(listNode.val);
    }
    return result;
}
```