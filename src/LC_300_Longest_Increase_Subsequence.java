/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/21
 */
public class LC_300_Longest_Increase_Subsequence {
    public int lengthOfLIS(int[] nums) {
        return lengthofLIS(nums,Integer.MIN_VALUE,0);
    }

    public int lengthofLIS(int[] nums, int prev,int curpos){
        if(curpos == nums.length){
            return 0;
        }

        int taken = 0;

        if(nums[curpos] > prev){
            taken = 1 + lengthofLIS(nums,nums[curpos],curpos + 1);
        }

        int nottaken = lengthofLIS(nums,prev,curpos+1);

        return Math.max(taken,nottaken);
    }


    public int lengthOfList(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];

        dp[0] = 1;

        int maxans = 1;
        for(int i = 1;i < dp.length;i++){
            int maxval = 0;

            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxval = Math.max(maxval,dp[j]);
                }
            }

            dp[i] = maxval + 1;
            maxans = Math.max(maxans,dp[i]);
        }

        return maxans;

    }


}