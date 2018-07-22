package com.wjq.code.alg;

public class LeetCode9 {

    /**
     * 使用额外的存储空间进行判断
     * @param x 需要判断的数字
     * @return 是回文数字则返回true，否则返回false
     */
    public static boolean isPalindrome(int x) {

        if (x < 0)
            return false;
        if (x >=0 && x <= 9)
            return true;

        int[] numberArray = new int[12];
        int i = 0, right, left;
        // 存储
        do {
            numberArray[i++] = x % 10;
            x /= 10;
        } while (x != 0);
        // 判断
        for (left = 0, right = i-1; left < right; left++, right--)
            if (numberArray[left] != numberArray[right])
                return false;

        return true;
    }

    /**
     * 反转一半的数字，如果是回文数字那么反转到一半的数字一定大于剩下的数字
     * @param x 需要判断的数字
     * @return 是回文数字则返回true，否则返回false
     */
    public static boolean isPalindrom2(int x) {
        // 特殊情况
        if (x <0 || (x % 10 == 0 && x!= 0))
            return false;

        int reversedNumber = 0;
        // 获得反转一半的数字和剩下的数字
        while (x > reversedNumber) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }
        // 判断两者是否相等或者等于后者除10
        return x == reversedNumber || x == reversedNumber / 10;
    }
}
