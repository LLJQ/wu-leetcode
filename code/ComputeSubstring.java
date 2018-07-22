package com.wjq.code.alg;

public class ComputeSubstring {

    /**
     * 使用动态规划算法计算两个字符串的最长子序列
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最长子序列的长度
     */
    public static int computeLength(String str1, String str2) {

        char[] strCharArray1 = str1.toCharArray();
        char[] strCharArray2 = str2.toCharArray();
        int len1 = strCharArray1.length;
        int len2 = strCharArray2.length;

        int[][] L = new int[len1][len2];

        int i, j, k, t;
        for (i = 1, k =0; i < len1; i++, k++) {
            for (j = 1, t = 0; j < len2; j++, t++) {
                if (strCharArray1[k] == strCharArray2[t]) {
                    L[i][j] = L[i-1][j-1] + 1;
                } else {
                    L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
                }
            }
        }

        for (i = 0; i < len1; i++) {
            for (j = 0; j < len2; j++) {
                System.out.print(String.valueOf(L[i][j]) + " ");
            }
            System.out.println();
        }

        return L[len1-1][len2-1];
    }
}
