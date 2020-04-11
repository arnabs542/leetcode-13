/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/19
 */
public class LC_334_IncreaseTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE,big = Integer.MAX_VALUE;

        for( int n : nums){
            if(n <= small){
                small = n;
            }else if ( n <= big){
                big = n;
            }else
                return true;
        }
        return false;

    }

    boolean increasingTriplet_2(int[] nums) {
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x <= c1) {
                c1 = x;           // c1 is min seen so far (it's a candidate for 1st element)
            } else if (x <= c2) { // here when x > c1, i.e. x might be either c2 or c3
                c2 = x;           // x is better than the current c2, store it
            } else {              // here when we have/had c1 < c2 already and x > c2
                return true;      // the increasing subsequence of 3 elements exists
            }
        }
        return false;
    }

}