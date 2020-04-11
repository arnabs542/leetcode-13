/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/15
 */
public class LC_34_Find_First_Last_In_Sorted_Array {
    public int[] searchRange(int[] nums,int target){

        int[] targetRange = {-1,-1};

        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                targetRange[0] = i;
                break;
            }
        }

        if(targetRange[0] == -1){
            return targetRange;
        }

        for(int j = nums.length-1;j>=0;j--){
            if(nums[j] == target){
                targetRange[1]=j;
                break;
            }
        }

        return targetRange;
    }




    public int[] searchRange_Binary_Search(int[] nums, int target){

        int[] targetRange = {-1,-1};

        int leftIdx = insertionIndex(nums,target,true);

        if(leftIdx == nums.length || nums[leftIdx] != target){
            return targetRange;
        }

        targetRange[0] = leftIdx;

        targetRange[1] = insertionIndex(nums,target,false)-1;
        return targetRange;
    }


    private int insertionIndex(int[] nums,int target,boolean left){
        int lo = 0;
        int hi = nums.length;

        while(lo<hi){
            int mid = lo +(hi-lo)/2;
            if(nums[mid] > target || (left && target == nums[mid])){
                hi = mid;
            }else{
                lo = mid +1;
            }
        }

        return lo;
    }












}