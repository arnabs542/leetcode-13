/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/19
 */
public class LC_128_Longest_Consecutive_Sequence {

    /*

    https://leetcode.com/problems/longest-consecutive-sequence/

    sort
     */

    public int longestConsecutive_Sort(int[] nums) {
        if(nums.length ==0){
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for(int i = 1; i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    currentStreak += 1;
                }else{
                    longestStreak = Math.max(longestStreak,currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak,currentStreak);
    }


    /*
     hash + iteration

     time complexity : O(n)
     space complexity: O(n)
     */
    public int longestConsecutive_Hash(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for(int num: nums){
            num_set.add(num);
        }

        int longestStreak = 0;

        for(int num: num_set){
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int currentStreak =1;

                while(num_set.contains(currentNum+1)){
                    currentNum = currentNum +1;
                    currentStreak +=1;
                }

                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }

        return longestStreak;
    }















}