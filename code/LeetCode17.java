package com.wjq.code.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {

    private static Map<Character, String> map = new HashMap<> (8);
    private static List<String> list = new ArrayList<>();

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * @param digits 目标数字字符串
     * @return 结果列表
     */
    public static List<String> letterCombinations(String digits) {

        int length = digits.length();
        if (length < 1)
            return list;

        NumberNode headNode = new NumberNode(map.get(digits.charAt(0)));
        initNode(headNode, length, digits);
        appendStr(headNode, "", 0);
        return list;
    }

    /**
     * 初始化节点
     * @param headNode 首节点
     * @param length 数字字符串的长度
     * @param target 数字字符串
     */
    private static void initNode(NumberNode headNode, int length, String target) {
        int i;
        NumberNode curr = headNode;
        for (i = 1; i < length; i++) {
            NumberNode temp = new NumberNode(map.get(target.charAt(i)));
            curr.next = temp;
            temp.prev = curr;
            curr = temp;
        }
    }

    /**
     * 字符添加
     * @param curr 当前节点
     * @param str 当前字符
     * @param index 当前位置
     */
    private static void appendStr(NumberNode curr, String str, int index) {
        int i;
        StringBuffer sb = new StringBuffer(str);
        for (i = 0; i < curr.length; i++) {
            sb.append(curr.value.charAt(i));
            processResult(curr, sb.toString(), index);
            sb.deleteCharAt(index);
        }
    }

    /**
     * 字符串处理
     * @param curr 当前节点
     * @param result 字符串结果
     * @param index 当前位置
     */
    private static void processResult(NumberNode curr, String result, int index) {
        int nextIndex = ++index;
        if (curr.next != null)
            appendStr(curr.next, result, nextIndex);
        else
            list.add(result);
    }

    static class NumberNode {
        String value;
        int length;
        NumberNode prev;
        NumberNode next;
        public NumberNode(String value) {
            this.value = value;
            this.length = value.length();
        }
    }


    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
