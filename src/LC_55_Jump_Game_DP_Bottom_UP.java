/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/3
 */
public class LC_55_Jump_Game_DP_Bottom_UP {

    enum Index{
        GOOD,BAD,UNKNOWS
    }

    public boolean canJump(int[] nums){
        Index[] memo = new Index[nums.length];
        for(int i = 0;i<memo.length;i++){
            memo[i] = Index.UNKNOWS;
        }

        memo[memo.length-1] = Index.GOOD;

        for( int i = nums.length-2;i>=0;i--){
            int furthestJump = Math.min(i+nums[i],nums.length-1);
            for(int j = i+1;j<= furthestJump;j++){
                if(memo[j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }

        }

        return memo[0] == Index.GOOD;
    }


}