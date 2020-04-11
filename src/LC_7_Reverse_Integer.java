/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/15
 */
public class LC_7_Reverse_Integer {
    public int reverse(int x) {
        int rev = 0;

        while(x!=0){
            int pop = x%10;
            x=x/10;

            if( rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7 )){
                return 0;
            }

            if( rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop <-8 )){
                return 0;
            }

            rev = rev*10 + pop;
        }

        return rev;
    }

    public int reverse_2(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }

}