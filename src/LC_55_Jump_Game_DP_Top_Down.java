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
public class LC_55_Jump_Game_DP_Top_Down {

    enum Index{
        GOOD,BAD,UNKNOWS
    }

    Index[] memo;

    public boolean canJumpFromPosition(int position,int[] nums){
        if(memo[position] != Index.UNKNOWS){
            return memo[position] == Index.GOOD?true:false;
        }

        int furthestJump = Math.min(position+nums[position],nums.length-1);
        for(int nextPosition =position+1;nextPosition <= furthestJump;nextPosition++){
            if(canJumpFromPosition(nextPosition,nums)){
                memo[position]= Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for(int i = 0;i<memo.length;i++){
            memo[i] = Index.UNKNOWS;
        }

        memo[memo.length-1] = Index.GOOD;
        return canJumpFromPosition(0,nums);
    }
}