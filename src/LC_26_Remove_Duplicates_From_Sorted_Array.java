/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/5
 */
public class LC_26_Remove_Duplicates_From_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        if ( nums.length == 0) return 0;

        int i = 0;
        for(int j = 1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }
}