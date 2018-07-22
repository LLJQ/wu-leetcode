package com.wjq.code.alg;

public class LeetCode10 {

    /**
     * 实现在a-z范围内字符的"."和"*"正则表达式
     * 未实现
     */
    public static boolean isMatch(String s, String p) {

        int i, j;
        int len1 = s.length(), len2 = p.length();
        int indexDot = 0, indexStar = 0;

        for (i = 0, j = 0; i <len1 && j < len2; i++, j++) {
            if ((indexDot = p.indexOf(".", indexDot)) != -1 && p.charAt(indexDot + 1) != '*') {

            }
        }

        return false;
    }
}
