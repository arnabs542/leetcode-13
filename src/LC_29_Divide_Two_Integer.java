/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/29
 */
public class LC_29_Divide_Two_Integer {
    public long divide(int dividend, int divisor) {
        if(divisor==0 ||
                dividend == Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;

        long res = 0;
        int sign = dividend< 0 == divisor <0 ? 1:-1;
        long dvd = Math.abs(dividend);
        long dvs = Math.abs(divisor);

        while(dvs<= dvd){
            long temp = dvs,mul = 1;
            while(dvd - temp >= temp){
                temp = temp<<1;
                mul = mul <<1;
            }
            dvd = dvd -temp;
            res = res + mul;
        }

        return sign == 1 ? res:-res;

    }

}