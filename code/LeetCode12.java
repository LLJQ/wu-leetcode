package com.wjq.code.alg;

import java.util.*;

public class LeetCode12 {

    /**
     * 罗马数字和整数映射
     */
    private static final Map<Integer, String> map = new HashMap<>(32);

    /**
     * 将[1, 3999]范围的整数转换为罗马数字表示
     */
    public static String intToRoman(int num) {

        int i = 1, curr = num, temp;
        List<String> list = new ArrayList<>();
        while (curr > 0) {  // 计算每一位数字的罗马数字表示
            temp = curr % 10;
            if (temp != 0)
                list.add(map.get(i * temp));
            i *= 10;
            curr /= 10;
        }
        // 将所有的罗马数字拼接起来
        Collections.reverse(list);
        StringBuffer result = new StringBuffer();
        for (String str : list)
            result.append(str);

        return result.toString();
    }

    static {
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(600, "DC");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(900, "CM");
        map.put(1000, "M");
        map.put(2000, "MM");
        map.put(3000, "MMM");
    }
}
