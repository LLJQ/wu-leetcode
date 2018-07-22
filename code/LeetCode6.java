package com.wjq.code.alg;

public class LeetCode6 {

    /**
     * 实现一个将字符串进行指定行数变换的函数
     * @param s 需要变换为Z形状的初始字符串
     * @param numRows 变化后的Z形状字符串的行数
     */
    public static String convert(String s, int numRows) {

        int len = s.length();
        StringBuffer sb = new StringBuffer();
        int i = 0, j = 0;
        int[] firstArray = new int[len];

        if (numRows == 1)
            return s;
        // 找出第一行的字符
        while (i < len) {
            sb.append(s.charAt(i));
            firstArray[j] = i;
            i += (numRows - 1) << 1;
            j++;
        }

        return findOtherLines(firstArray, s, sb, numRows, j);
    }

    private static String findOtherLines(int[] firstArray, String s, StringBuffer sb, int rows, int size) {
        int k, t, temp, len = s.length();
        for (k = 1; k < rows; k++) {
            for (t = 0; t < size && (temp = firstArray[t] + k) < len; t++) {
                if (k != (rows - 1)){  // 中间行的字符
                    sb.append(s.charAt(temp));
                    temp += ((rows - k - 1) << 1);
                    if (temp < len)
                        sb.append(s.charAt(temp));
                } else { //最底行的字符
                    sb.append(s.charAt(temp));
                }
            }
        }
        return sb.toString();
    }
}
