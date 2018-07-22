package com.wjq.code.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {

    static List<List<Integer>> list = new ArrayList<>();

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * @param nums 整数数组
     * @return 满足条件的解
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        int[] numberArray = nums;
        int left = 0, right = numberArray.length - 1;
        list.clear();
        if (right < 2)
            return list;

        Arrays.sort(numberArray, left, right+1);  // 排序
        findThreeNumber(numberArray, left, right);
        return list;
    }

    private static void findThreeNumber(int[] numberArray, int left, int right) {
        int i = left + 1;
        findTwoNumber(numberArray, i, right, numberArray[i-1]);

        for (; numberArray[i] <= 0 && i < right; i++) {
            if (numberArray[i] != numberArray[i-1]) {
                findTwoNumber(numberArray, i+1, right, numberArray[i]);
            }
        }
    }

    private static void findTwoNumber(int[] numberArray, int left, int right, int temp) {

        int curr, l = left, r = right;
        while (l < r) {
            curr = numberArray[l] + numberArray[r] + temp;
            if (curr < 0) {
                l++;
            } else if (curr > 0) {
                r--;
            } else {
                processResult(numberArray[l], numberArray[r], temp);
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

    private static void processResult(int first, int second, int third) {

        List<Integer> localList = new ArrayList<>();
        localList.add(first);
        localList.add(second);
        localList.add(third);
        list.add(localList);
    }
}
