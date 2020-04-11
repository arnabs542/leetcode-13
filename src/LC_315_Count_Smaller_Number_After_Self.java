/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/24
 */
public class LC_315_Count_Smaller_Number_After_Self {


    /**
     *     The smaller numbers on the right of a number are exactly
     *     those that jump from its right to its left during a stable sort.
     *     So I do mergesort with added tracking of those right-to-left jumps.
     */

    class Pair{
        int index;
        int val;

        public Pair(int index,int val){
            this.index = index;
            this.val = val;
        }
    }



    public List<Integer> countSmaller(int[] nums){
        List<Integer> res = new ArrayList<>();

        if( nums == null || nums.length < 1){
            return res;
        }

        Pair[] arr = new Pair[nums.length];

        Integer[] smaller = new Integer[nums.length];

        Arrays.fill(smaller, 0);

        for(int i = 0; i<nums.length;i++){
            arr[i]  = new Pair(i,nums[i]);
        }

        mergeSort(arr,smaller);

        res.addAll(Arrays.asList(smaller));

        return res;
    }

    private Pair[] mergeSort(Pair[] arr,Integer[] smaller){
        if(arr.length <= 1){
            return arr;
        }

        int mid = arr.length/2;

        Pair[] left = mergeSort(Arrays.copyOfRange(arr,0,mid),smaller);
        Pair[] right = mergeSort(Arrays.copyOfRange(arr,mid+1,arr.length),smaller);

        for(int i = 0,j = 0; i<left.length || j<right.length;){
            if( j == right.length || i < left.length &&arr[i].val < arr[j].val){
                arr[i+j] = left[i];
                smaller[left[i].index] += j;
                i++;
            }else{
                arr[i+j] = right[j];
                j++;
            }
        }

        return arr;


    }




}