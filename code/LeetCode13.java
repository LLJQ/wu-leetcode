package com.wjq.code.alg;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {

    /**
     * 罗马数字和整数的映射
     */
    private static final Map<String, Integer> map = new HashMap<>(32);

    /**
     * 将[1, 3999]罗马数字字符串转换为整数表示
     */
    public static int romanToInt(String s) {

        int i, j = 1, len = s.length();
        int sum = 0, temp = 0;
        for (i = 0; i < len; i = j - 1) {
            while (j <= len && map.get(s.substring(i, j)) != null) {
                temp = map.get(s.substring(i, j));
                j++;
            }
            sum += temp;
        }

        return sum;
    }

    static {

        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XX", 20);
        map.put("XXX", 30);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("LX", 60);
        map.put("LXX", 70);
        map.put("LXXX", 80);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CC", 200);
        map.put("CCC", 300);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("DC", 600);
        map.put("DCC", 700);
        map.put("DCCC", 800);
        map.put("CM", 900);
        map.put("M", 1000);
        map.put("MM", 2000);
        map.put("MMM", 3000);
    }
}
