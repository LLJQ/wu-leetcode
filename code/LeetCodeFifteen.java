package com.wjq.code.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LeetCodeFifteen {
    public static void main(String[] args) {
        System.out.println("Hello");

        int[] nums = new int[] {-2,0,0,2,2};
        int[] nums1 = new int[] {-4, -3, -2, -1, 0, 1, 2, 2, 5};
        int[] nums2 = new int[] {-4,-1,-4,0,2,-2,-4,-3,2,-3,2,3,3,-4};
        System.out.println(threeSum(nums));
    }

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
        int i;
        list.clear();
        if (right < 2)
            return list;

        Arrays.sort(numberArray, left, right+1);  // 排序

        find(numberArray, 1, right, numberArray[0]);
        for (i = 1; numberArray[i] <= 0 && i < right; i++) {
            if (numberArray[i] != numberArray[i-1]) {
                find(numberArray, i+1, right, numberArray[i]);
            }
        }
        return list;
    }

    private static void find(int[] numberArray, int left, int right, int temp) {

        int curr;

        while (left < right) {
            curr = numberArray[left] + numberArray[right] + temp;
            if (curr < 0) {
                left++;
            } else if (curr > 0) {
                right--;
            } else {
                List<Integer> localList = new ArrayList<>();
                localList.add(numberArray[left]);
                localList.add(numberArray[right]);
                localList.add(temp);
                list.add(localList);
                left++;
                right--;
                while (numberArray[left] == numberArray[left-1] && left < right) {
                    left++;
                }
                while (numberArray[right] == numberArray[right+1] && left < right) {
                    right--;
                }
            }
        }
    }
}
