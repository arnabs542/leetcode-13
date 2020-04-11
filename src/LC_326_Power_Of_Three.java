/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/30
 */
public class LC_326_Power_Of_Three {

    public boolean isPowerOfThree(int n) {
        if( n < 1){
            return false;
        }

        while( n % 3 == 0){
            n = n/3;
        }

        return n == 1;
    }


    /*

    
     */

    public boolean isPowerOfThree_2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


}