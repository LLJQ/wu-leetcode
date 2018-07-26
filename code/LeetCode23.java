package com.wjq.code.alg;

public class LeetCode23 {
    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * @param lists 目标链表
     * @return 结果头结点
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        int i, min, index, size = lists.length;

        if (size < 1)
            return null;

        if (size == 1)
            return lists[0];

        ListNode[] listArray = lists;
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (true) {
            // 判断是否为空
            for (i = 0; i < size && listArray[i] == null; i++) {
            }

            if (i < size) {
                min = listArray[i].val;
                index = i;
            } else {
                break;
            }
            // 找到最小值
            for (i = 0; i < size; i++) {
                if (listArray[i] != null && listArray[i].val < min) {
                    min = listArray[i].val;
                    index = i;
                }
            }
            // 更新
            curr.next = new ListNode(min);
            curr = curr.next;
            listArray[index] = listArray[index].next;
        }

        return head.next;
    }
}
