/*
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 19/9/23
 */
public class LC_29_Divide {

    public int divide(int dividend,int divisor){
        int acc = divisor;
        int count = 0;

        while(dividend - acc >= 0){
            acc += divisor;
            count++;
        }
        return count;
    }

    public int divideWithIndex(int dividend,int divisor) {

        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);

        long a = Math.abs((long) dividend);

        long b = Math.abs((long) divisor);

        int result = 0;

        while (a >= b) {
            int shift = 0;

            while (a >= (b << shift)) {
                shift++;
            }

            a -= b << (shift - 1);

            result = result + 1 << (shift - 1);

        }

        return result;
    }



}