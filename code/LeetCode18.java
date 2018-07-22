package com.wjq.code.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {

    private static List<List<Integer>> list = new ArrayList<>();
    private static int localTarget;

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * @param nums 目标数组
     * @param target 目标数值
     * @return 满足条件的解的列表
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        int[] numberArray = nums;
        int left = 0, right = numberArray.length - 1;
        localTarget = target;
        if (right < 3)
            return list;

        Arrays.sort(numberArray, left, right+1);
        findFourNumber(numberArray, left, right);

        return list;
    }

    private static void findFourNumber(int[] numberArray, int left, int right) {

        int i = left + 1;
        findThreeNumber(numberArray, i, right, numberArray[i-1]);
        for (; right - i > 2; i++) {
            if (numberArray[i] != numberArray[i-1]) {
                findThreeNumber(numberArray, i+1, right, numberArray[i]);
            }
        }
    }

    private static void findThreeNumber(int[] numberArray, int left, int right, int first) {

        int i = left + 1;
        findTwoNumber(numberArray, i, right, first, numberArray[i-1]);
        for (; right - i > 1; i++) {
            if (numberArray[i] != numberArray[i-1])
                findTwoNumber(numberArray, i+1, right, first, numberArray[i]);
        }
    }

    private static void findTwoNumber(int[] numberArray, int left, int right, int first, int second) {

        int curr, l = left, r = right;
        while (l < r) {
            curr = first + second + numberArray[l] + numberArray[r];
            if (curr < localTarget) {
                l++;
            } else if (curr > localTarget) {
                r--;
            } else {
                processResult(first, second, numberArray[l], numberArray[r]);
                l++;
                r--;
                while (numberArray[l] == numberArray[l-1] && l < r) {
                    l++;
                }
                while (numberArray[r] == numberArray[r+1] && l < r) {
                    r--;
                }
            }
        }
    }

    private static void processResult(int first, int second, int third, int four) {
        List<Integer> temp = new ArrayList<>(4);
        temp.add(first);
        temp.add(second);
        temp.add(third);
        temp.add(four);
        list.add(temp);
    }
}
