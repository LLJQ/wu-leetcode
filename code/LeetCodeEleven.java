package com.wjq.code.alg;

import java.util.Arrays;
import java.util.Collections;

public class LeetCodeEleven {
    public static void main(String[] args) {
        System.out.println("Hello");

        int[] array = new int[]{1, 2, 4, 3};
        System.out.println(maxArea(array));
    }
    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     */
    public static int maxArea(int[] height) {

        int area = 0, temp;
        int left = 0, right = height.length - 1;
        while (left < right) {
            temp = Math.min(height[left], height[right]) * (right - left); // 计算
            area = Math.max(area, temp);  // 取最大区域
            if (height[left] < height[right])  // 留最长的线条
                left++;
            else
                right--;
        }
        return area;
    }
}
