package com.wjq.code.alg;

public class LeetCode26 {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，
     * 返回移除后数组的新长度。不要使用额外的数组空间，
     * 你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * @param nums 目标数组
     * @return 结果值
     */
    public static int removeDuplicates(int[] nums) {

        int length = nums.length;
        if (length < 1)
            return 0;
        if (length == 1)
            return 1;

        int size = 1, temp = nums[0], i;
        for (i = 1; i < length; i++) {
            if (temp != nums[i]) {
                temp = nums[i];
                // 交换值
                swap(nums, i, size);
                size++;
            }
        }
        return size;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
