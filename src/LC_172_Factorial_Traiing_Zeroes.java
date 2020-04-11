/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/1
 */
public class LC_172_Factorial_Traiing_Zeroes {

    // f(n)=n/5+f(n/5)
    public int trailingZeroes(int n) {

        if ( n == 0){
            return 0;
        }else{
            return n/5 + trailingZeroes(n/5);
        }
    }

}