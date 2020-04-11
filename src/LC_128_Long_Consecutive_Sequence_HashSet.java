/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/26
 */
public class LC_128_Long_Consecutive_Sequence_HashSet {

    private boolean arrayContains(int[] arr,int num){
        for(int i = 0; i< arr.length;i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();

        for(int num:nums){
            num_set.add(num);
        }

        int longestStreak = 0;

        for(int num:num_set){
            if(!num_set.contains(num-1)){
                int currentNUm = num;
                int currentStreak = 1;

                while(num_set.contains(currentNUm+1)){
                    currentNUm +=1;
                    currentStreak +=1;
                }

                longestStreak = Math.max(currentStreak,longestStreak);
            }
        }

        return longestStreak;

    }


    

}