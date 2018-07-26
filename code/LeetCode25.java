package com.wjq.code.alg;

public class LeetCode25 {
    /**
     * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，
     * 那么将最后剩余节点保持原有顺序。
     * @param head 目标链表头结点
     * @param k 组大小
     * @return 结果链表
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head, tempCurr = null, tempHead = null;
        ListNode[] listNodes = new ListNode[k];
        int i;

        if (curr == null || k < 1)
            return null;
        if (k == 1)
            return curr;

        while (curr != null) {
            // 分割
            for (i = 0; i < k; i++) {
                if (curr != null) {
                    listNodes[i] = curr;
                    curr = curr.next;
                } else {
                    return tempHead != null ? tempHead : head;
                }
            }
            // 交换
            for (i = k - 1; i >= 0; i--) {
                if (tempHead == null) {
                    tempHead = listNodes[i];
                    tempCurr = listNodes[i];
                } else {
                    tempCurr.next = listNodes[i];
                    tempCurr = tempCurr.next;
                }
            }
            tempCurr.next = curr;
        }
        return tempHead;
    }
}
