package com.wjq.code.alg;

import java.util.Arrays;

public class LeetCode16 {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
     * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * @param nums 整数数组
     * @param target 目标值
     * @return 满足条件的和
     */
    public static int threeSumClosest(int[] nums, int target) {

        int[] numberArray = nums;
        int left = 0, right = numberArray.length - 1;

        Arrays.sort(numberArray);
        int curr = find(numberArray, ++left, right, target - numberArray[0]);
        int min = curr;

        if (curr == 0)
            return target;

        for (;left < right-1; left++) {
            curr = find(numberArray, left+1, right, target - numberArray[left]);

            if (curr == 0)
                return target;
            else
                min = Math.abs(curr) < Math.abs(min) ? curr : min;
        }

        return target - min;
    }

    private static int find(int[] numberArray, int left, int right, int temp) {

        int curr;
        int min = temp - numberArray[left] - numberArray[right];

        while (left < right) {
            curr = temp - numberArray[left] - numberArray[right];
            if (curr < 0)
                right--;
            else if (curr > 0)
                left++;
            else
                return curr;

            min = Math.abs(min) > Math.abs(curr) ? curr : min;
        }
        return min;
    }
}
