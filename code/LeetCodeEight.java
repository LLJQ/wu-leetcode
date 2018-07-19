package com.wjq.code.alg;

public class LeetCodeEight {
    public static void main(String[] args) {
        System.out.println("Hello");

        System.out.println(myAtoi("2147483648"));
    }

    /**
     * 实现 atoi，将字符串转为整数。
     * @param str 字符串
     * @return 返回值
     */
    public static int myAtoi(String str) {

        str = str.trim();  // 取出空格
        int len = str.length();
        if (len < 1)
            return 0;

        char firstChar = str.charAt(0);
        int result;

        if (firstChar <= '9' && firstChar >= '0') {  // 首位是数字
            result = convertInteger(str, 1, firstChar, true);
        } else if (firstChar == '+') {  // 首位是正号
            if (len > 1 && (firstChar = str.charAt(1)) <= '9' && firstChar >= '0')
                result = convertInteger(str, 2, firstChar, true);
            else
                result = 0;
        } else if (firstChar == '-') {  // 首位是负号
            if (len > 1 && (firstChar = str.charAt(1)) <= '9' && firstChar >= '0')
                result = convertInteger(str, 2, firstChar, false);
            else
                result = 0;
        } else {  // 首位是其他字符
            result = 0;
        }
        return result;
    }

    private static int convertInteger(String str, int i, char firstChar, boolean flag) {
        long result;
        char tempChar;
        int len = str.length();
        result = firstChar - '0';
        while (i < len && (tempChar = str.charAt(i)) <= '9' && tempChar >= '0') {
            result = result * 10 + (tempChar - '0');
            i++;
            if (flag && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (!flag && -result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)(flag ? result : -result);
    }
}
