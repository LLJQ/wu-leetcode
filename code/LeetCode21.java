package com.wjq.code.alg;

public class LeetCode21 {

    /**
     * 将给定的两个链表合为一个
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并的链表
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode p1 = l1, p2 = l2, curr;
        ListNode head = new ListNode(0);
        curr = head;

        while (p1 != null && p2 != null) {
            curr.next = new ListNode(p1.val <= p2.val ? p1.val : p2.val);
            curr = curr.next;

            if (p1.val <= p2.val )
                p1 = p1.next;
            else
                p2 = p2.next;
        }

        while (p1 != null) {
            curr.next = new ListNode(p1.val);
            curr = curr.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            curr.next = new ListNode(p2.val);
            curr = curr.next;
            p2 = p2.next;
        }

        return head.next;
    }
}
