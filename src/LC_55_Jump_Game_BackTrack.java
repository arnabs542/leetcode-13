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
public class LC_55_Jump_Game_BackTrack {

    public boolean canJumpFromPosition(int position,int[] nums){
        if(position == nums.length -1){
            return true;
        }

        int furthestJump = Math.min(position + nums[position],nums.length-1);

        for( int nextPosition = position+1; nextPosition <= furthestJump;nextPosition++){
            if(canJumpFromPosition(nextPosition,nums)){
                return true;
            }
        }

        return false;
    }
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0,nums);
    }
}