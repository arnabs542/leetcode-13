/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Arrays;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/24
 */
public class LC_300_Longest_Increasing_Subsequence {

    /*

        input: [0, 8, 4, 12, 2]

        dp: [0]

        dp: [0, 8]

        dp: [0, 4]

        dp: [0, 4, 12]

        dp: [0 , 2, 12] which is not the longest increasing subsequence,
        but length of dpdp array results in length of Longest Increasing Subsequence.

     */
    public int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];

        int len = 0;

        for( int num: nums){
            int i = Arrays.binarySearch(dp,num);
            /*
                index of the search key, if it is contained in the array;
                otherwise, (-(insertion point) - 1). The insertion point is defined
                as the point at which the key would be inserted into the array:
                the index of the first element greater than the key, or a.length
                if all elements in the array are less than the specified key.
                Note that this guarantees that the return value will be >= 0
                if and only if the key is found.
             */
            if(i<0){
                i = -i -1;
            }

            dp[i] = num;
            if(i == len){
                len++;
            }
        }

        return len;

    }



    /*

        tails is an array storing the smallest tail of all increasing
        subsequences with length i+1 in tails[i].
        For example, say we have nums = [4,5,6,3], then all the
        available increasing subsequences are:

        len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
        len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
        len = 3   :      [4, 5, 6]            => tails[2] = 6

        We can easily prove that tails is a increasing array.
        Therefore it is possible to do a binary search in tails
        array to find the one needs update.

        Each time we only do one of the two:

        (1) if x is larger than all tails, append it, increase the size by 1
        (2) if tails[i-1] < x <= tails[i], update tails[i]

     */


    public int lengthOfLIS_2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }







}