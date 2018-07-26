package com.wjq.code.alg;

public class LeetCode27 {
    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
     * 返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1)
     * 额外空间的条件下完成。元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @param nums 目标数组
     * @param val 目标值
     * @return 结果值
     */
    public static int removeElement(int[] nums, int val) {

        int i, size = 0, length = nums.length;

        if (length < 1)
            return 0;

        for (i = 0; i < length; i++) {
            if (nums[i] != val) {
                if (size < i)
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
