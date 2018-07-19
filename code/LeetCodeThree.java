package com.wjq.code.alg;

public class LeetCodeThree {

    public static void main(String[] args) {

        System.out.println("Hello World");

        System.out.println(lengthOfLongestSubstring(""));
    }

    /**
     * 找出不含有重复字符的最长子串的长度。
     * @param s 目标字符串
     */
    public static int lengthOfLongestSubstring(String s) {

        int len = 0, tempLen = 1, length, i, j;
        char[] charArray = s.toCharArray();
        length = charArray.length;
        int start = 0;
        boolean flag;

        if (length == 0) return 0;

        for (i = 1; i < length; i++) {
            flag = true;
            for (j = start; j < i; j++) {
            	// 如果发现重复字符，窗口向前滑动直到不包含该字符的首次出现
                if (charArray[j] == charArray[i]) {
                    flag = false;
                    start = j+1;
                    j = i;
                    if (len < tempLen) {
                        len = tempLen;
                    }
                    tempLen = i - start + 1;
                }
            }
            if (flag) {
                tempLen++;
            }
        }

        return len > tempLen ? len : tempLen;
    }
}
