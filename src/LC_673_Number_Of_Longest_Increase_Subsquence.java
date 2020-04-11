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
 * @created 20/4/9
 */
public class LC_673_Number_Of_Longest_Increase_Subsquence {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;

        if ( N <= 1){
            return N;
        }

        int[] lengths = new int[N]; // length of longest ending in nums[i]
        int[] counts = new int[N]; // number of longest ending in nums[i]

        Arrays.fill(counts,1);

        for(int j = 0;j<N;++j){
            for(int i=0;i<j;++i){
                if(nums[i] < nums[j]){
                    if(lengths[i]>=lengths[j]){
                        lengths[j] = lengths[i] +1;
                        counts[j] = counts[i];
                    }else if (lengths[i] +1 == lengths[j]){
                        counts[j] +=counts[i];
                    }
                }
            }
        }

        int longest =0, ans = 0;

        for( int length: lengths){
            longest = Math.max(longest,length);
        }

        for( int i = 0;i<N;++i){
            if(lengths[i] == longest){
                ans  = ans +  counts[i];
            }
        }

        return ans;
    }



















}