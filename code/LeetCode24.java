package com.wjq.code.alg;

public class LeetCode24 {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * @param head 链表头结点
     * @return 结果链表
     */
    public static ListNode swapPairs(ListNode head) {

        ListNode curr = head, temp;
        ListNode tempHead = null;
        ListNode tempCurr = null;

        if (curr == null)
            return null;
        if (curr.next == null)
            return curr;

        while (curr.next != null) {
            // 交换
            temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            // 更新
            if (tempHead == null) {
                tempHead = temp;
                tempCurr = temp.next;
            } else {
                tempCurr.next = temp;
                tempCurr = tempCurr.next;
                tempCurr = tempCurr.next;
            }
            // 判断
            if (curr.next != null) {
                curr = curr.next;
            }
        }

        return tempHead;
    }
}
