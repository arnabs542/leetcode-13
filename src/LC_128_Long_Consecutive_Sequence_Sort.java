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
 * @created 20/1/26
 */
public class LC_128_Long_Consecutive_Sequence_Sort {

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for(int i = 1;i<nums.length;i++){
            if(nums[i]!= nums[i-1]){
                if(nums[i] == nums[i-1] +1){
                    currentStreak +=1;
                }else{
                    longestStreak = Math.max(longestStreak,currentStreak);
                    currentStreak = 1;
                }
            }
        }


        return Math.max(longestStreak,currentStreak);
    }


    

}