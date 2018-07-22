package com.wjq.code.alg;

public class LeetCode7 {

    /**
     * range [-2^31, 2^31-1]
     * @param x 输入
     * @return 返回反转的整数
     */
    public static int reverse(int x) {

    	int curr = x;
        curr = Math.abs(curr);
        long sum = curr % 10;
        curr /= 10;

        // 反转
        while (curr != 0) {
            sum = sum*10 + curr % 10;
            curr /= 10;
            
        }
        // 判断正负
        sum = x > 0 ? sum : -sum;
        // 判断是否溢出
        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE)
            return 0;

        return (int)sum;
    }
}
