package com.wjq.code.alg;

public class LeetCodeSix {
    public static void main(String[] args) {
        System.out.println("Hello");

        String str = "012345678";
        System.out.println(convert(str, 6));
    }

    /**
     * 实现一个将字符串进行指定行数变换的函数
     * @param s 需要变换为Z形状的初始字符串
     * @param numRows 变化后的Z形状字符串的行数
     */
    public static String convert(String s, int numRows) {

        int len = s.length();
        StringBuffer sb = new StringBuffer();
        int i = 0, j = 0, k, t;
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
        int temp;
        // 找出其它行的字符
        for (k = 1; k < numRows; k++) {
            for (t = 0; t < j && (temp = firstArray[t] + k) < len; t++) {
                if (k != (numRows - 1)){  // 中间行的字符
                    sb.append(s.charAt(temp));
                    temp += ((numRows - k - 1) << 1);
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
