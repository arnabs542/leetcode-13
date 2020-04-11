/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Arrays;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/24
 */
public class LC_315_Count_Smaller_Number_After_Self_2 {


    /**
     *     The smaller numbers on the right of a number are exactly
     *     those that jump from its right to its left during a stable sort.
     *     So I do mergesort with added tracking of those right-to-left jumps.
     */

    class NumberIndex{
        int number;
        int index;
        NumberIndex(int number,int index){
            this.number = number;
            this.index = index;
        }
    }


    public List<Integer> countSmaller(int[] nums){

        NumberIndex[] cnums = new NumberIndex[nums.length];
        for(int i =0;i<nums.length;i++){
            cnums[i] = new NumberIndex(nums[i],i);
        }

        Integer[] smaller = new Integer[nums.length];

        cnums = sort(cnums,smaller);

        List<Integer> res = Arrays.asList(smaller);
        return res;
    }


    private NumberIndex[] sort(NumberIndex[] nums, Integer[] smaller){
        int half = nums.length/2;

        if(half>0){
            NumberIndex[] rightPart = new NumberIndex[nums.length - half];
            NumberIndex[] leftPart = new NumberIndex[half];

            for(int i = 0; i<leftPart.length;i++){
                leftPart[i] = new NumberIndex(nums[i].number,nums[i].index);
            }


            for(int i = 0; i<rightPart.length;i++){
                rightPart[i] = new NumberIndex(nums[half+i].number,nums[half+i].index);
            }


            NumberIndex[] left = sort(leftPart,smaller);
            NumberIndex[] right = sort(rightPart,smaller);

            int m = left.length,n = right.length, i = 0, j = 0;

            while(i<m || j< n){
                if(j == n || i<m && left[i].number < right[j].number){
                    nums[i+j] = left[i];
                    smaller[left[i].index] = smaller[i] + j;
                    i++;
                }else{
                    nums[i+j] = right[j];
                    j++;
                }
            }

        }

        return nums;
    }









}