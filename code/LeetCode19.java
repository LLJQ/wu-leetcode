package com.wjq.code.alg;

public class LeetCode19 {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * @param head 目标链表
     * @param n 目标序号
     * @return 结果链表的头结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        ListNode curr = head, tempHead = head;
        while (curr.next != null) {
            length++;
            curr = curr.next;
            if (length > n)
                tempHead = tempHead.next;
        }

        if (length - n < 0) {
            return head.next;
        } else {
            tempHead.next = tempHead.next.next;
            return head;
        }
    }
}
