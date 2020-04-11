/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/26
 */
public class LC_128_Long_Consecutive_Sequence {

    private boolean arrayContains(int[] arr,int num){
        for(int i = 0; i< arr.length;i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {

        int longestStreak = 0;

        for(int num: nums){
            int currentNum = num;
            int currentStreak = 1;
            while(arrayContains(nums,num++)){
                currentStreak +=1;
            }

            longestStreak = Math.max(longestStreak,currentStreak);
        }
        return longestStreak;
    }




}