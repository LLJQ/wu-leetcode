package com.wjq.code.alg;

import java.util.Stack;

public class LeetCode20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * @param s 目标字符串
     * @return 满足条件返回true，否则返回false
     */
    public static boolean isValid(String s) {

        Stack stack = new Stack();
        int i = 0, length = s.length();
        char top, curr;
        if (length < 1)
            return true;

        stack.push(s.charAt(i++));
        for (; i < length; i++) {
            curr = s.charAt(i);
            if (stack.empty()) {
                stack.push(curr);
            }
            else {
                top = (char)stack.peek();
                if ((top == '(' && curr == ')') || (top == '{' && curr == '}') ||
                        (top == '[' && curr == ']') ) {
                    stack.pop();
                } else {
                    stack.push(curr);
                }
            }

        }
        return stack.empty();
    }
}
