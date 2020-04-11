/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/26
 */
public class LC_53_Maximum_Subarray {
    /*
    this problem was discussed by Jon Bentley (Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885)
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1;i<n;i++){
            if(dp[i-1]>0){
                dp[i] = nums[i] + dp[i-1];
            }else{
                dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }

}