package com.wjq.code.alg;

public class LeetCode5 {

    /**
     * 找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000
     * @param s 目标字符串
     */
    public static String longestPalindrome(String s) {
        int start = 0, end = 0, length = s.length();
        int len1, len2, len, i;

        for (i = 0; i < length; i++) {
            len1 = expandAroundCenter(s, i, i, length);
            len2 = expandAroundCenter(s, i, i + 1, length);
            len = Math.max(len1, len2);
            // 更新回文字符串的长度
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right, int len) {
        int L = left, R = right;
        while (L >= 0 && R < len && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
