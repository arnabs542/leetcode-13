/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/24
 */
public class LC_334_Increase_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        for(int n: nums){
            if(n <=first){
                first =n;
            }else if ( n <=second){
                second = n;
            }else{
                return true;
            }
        }

        return false;

    }
















}