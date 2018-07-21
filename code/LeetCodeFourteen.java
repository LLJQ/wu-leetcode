package com.wjq.code.alg;

public class LeetCodeFourteen {
    public static void main(String[] args) {
        System.out.println("Hello");

        String[] strs = new String[] {"hello", "", "heo"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 查找字符串数组中的最长公共前缀
     * @param strs 字符数组
     * @return 最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {

        int length = strs.length;
        int tempLen = 0, i, j;
        char curr;
        String result = "";

        if (length > 0)
            tempLen = strs[0].length();
        else
            return "";

        for (i = 1; i < length; i++) {
            if (tempLen > strs[i].length()) {
                tempLen = strs[i].length();
            }
        }

        for (i = 0; i < tempLen; i++) {
            curr = strs[0].charAt(i);
            for (j = 1; j < length; j++) {
                if (curr != strs[j].charAt(i)) {
                    return result;
                }
            }
            result = result + curr;
        }

        return result;
    }
}
