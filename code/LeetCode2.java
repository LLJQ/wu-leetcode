package com.wjq.code.alg;

public class LeetCode2 {

    /**
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
     * 将两数相加返回一个新的链表。
     * @param l1 链表1
     * @param l2 链表2
     */
    public static ListNode addTwoNUmber(ListNode l1, ListNode l2) {

        int temp, value1, value2;
        int j = 0;
        ListNode headNode = new ListNode(0);
        ListNode p = l1, q = l2, curr = headNode;

        while (p != null || q != null) {
        	// 计算两个节点值和进位的和
            value1 = p != null ? p.val : 0;
            value2 = q != null ? q.val : 0;
            temp = value1 + value2 + j;

            j = temp / 10;  // 进位则大于0，否则等于0
            curr.next = new ListNode(temp % 10);  // 存储个位结果
            // 更新节点
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        // 判断最终是否有进位
        if (j > 0) curr.next = new ListNode(j);
        return headNode.next;
    }
}