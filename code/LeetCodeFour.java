package com.wjq.code.alg;

public class LeetCodeFour {

    public static void main(String[] args) {

        System.out.println("Hello World");

        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2, 3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 
     * @param nums1 数组1
     * @param nums2 数组2
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int temp = (len1 + len2) / 2;

        if ((len1 + len2) % 2 == 1) {  // 中位数为1个数字
            if (len1 == 0)
                return nums2[temp];
            if (len2 == 0)
                return nums1[temp];

            return findFirstNumber(temp, nums1, nums2, false);
        } else {  // 中位数为两个数字的平均值
            if (len1 == 0)
                return (nums2[temp-1] + nums2[temp]) / 2.0;
            if (len2 == 0)
                return (nums1[temp-1] + nums1[temp]) / 2.0;

            return findFirstNumber(temp, nums1, nums2, true);
        }
    }

    /**
     * 计算中位数
     * @param median 第一个中位数的位置
     * @param nums1 数组1
     * @param nums2 数组2
     * @param flag true则表示中位数为两个数字平均值，false表示中卫数为一个数字
     */
    private static double findFirstNumber(int median, int[] nums1, int[] nums2, boolean flag) {

        int i, j = 0, k = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        double curr = 0.0;

        if (flag)
            median--;

        // 找出第一个中位数的值
        for (i = 0; i <= median; i++) {
            if (j == len1)
                curr = nums2[k++];
            else if (k == len2)
                curr = nums1[j++];
            else
                curr = nums1[j] < nums2[k] ? nums1[j++] : nums2[k++];
        }
        // 如果满足条件，则找出第二个中位数的值
        if (flag) {
            if (j == len1) {
                curr = (curr + nums2[k]) / 2.0;
            } else if (k == len2) {
                curr = (curr + nums1[j]) / 2.0;
            } else {
                curr = (curr + (nums1[j] < nums2[k] ? nums1[j] : nums2[k])) / 2.0;
            }
        }
        return curr;
    }

}
