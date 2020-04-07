package algorithms.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by liuwei on 2020/4/7
 */
public class 从尾到头打印链表 {

    //递归
    public ArrayList<Integer> printListFromTailToHead01(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            result.addAll(printListFromTailToHead01(listNode.next));
            result.add(listNode.val);
        }
        return result;
    }

    //利用栈的先进先出
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

    //先翻转再打印
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

}
