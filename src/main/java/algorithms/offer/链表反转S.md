# 反转链表

## 题目链接

[牛客网](https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github)

## 题目描述

输入一个链表，反转链表后，输出新链表的表头。

## 解题思路

### 1.使用头插法

```java
public ListNode ReverseList(ListNode head) {
    ListNode preNode = null;
    while (head != null) {
        ListNode temp = head.next;
        head.next = preNode;
        preNode = head;
        head = temp;
    }
    return preNode;
}
```

### 2. 递归

```java
public ListNode ReverseList02(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode next = head.next;
    head.next  = null;
    ListNode result = ReverseList02(next);
    next.next = head;
    return result;
}
```