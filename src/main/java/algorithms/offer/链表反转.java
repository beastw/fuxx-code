package algorithms.offer;

/**
 * Created by liuwei on 2020/4/7
 */
public class 链表反转 {

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

}
