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
 * @created 20/4/11
 */
public class LC_416_Partiton_Equal_Subset_Sum {



    /*

     https://leetcode.com/problems/partition-equal-subset-sum/

     assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers

     Transition function: For each number, if we don't pick it, dp[i][j] = dp[i-1][j],
     which means if the first i-1 elements has made it to j, dp[i][j] would also make
     it to j (we can just ignore nums[i]).
     If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]], which represents that j is
     composed of the current value nums[i] and the remaining composed of other previous numbers.
     Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]

     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum = sum + num;
        }

        /*

        if (volumn % 2 != 0) {
            return false;
        }

         */

        if( (sum & 1) == 1){
            return false;
        }

        sum = sum/2;
        int n = nums.length;

        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i = 0 ;i<dp.length;i++){
            Arrays.fill(dp[i],false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for(int i = 1; i<n+1;i++){
            for(int j = 1;j<sum+1;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }



    public boolean canPartition_One_Array(int[] nums){
        int sum = 0;

        for(int num: nums){
            sum = sum + num;
        }

        if( (sum & 1) == 1){
            return false;
        }

        sum = sum/2;
        int n = nums.length;

        boolean[] dp = new boolean[sum+1];

        Arrays.fill(dp,false);

        dp[0] = true;

        for(int num: nums){
            for( int i=sum;i>0;i--){
                if( i >= num){
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }



































}