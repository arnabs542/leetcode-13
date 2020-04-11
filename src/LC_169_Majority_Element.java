/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/10
 */
public class LC_169_Majority_Element {
    /*

    https://en.jinzhao.wiki/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm

     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for(int num: nums){
            if( count == 0){
                candidate = num;
                count = 1;
            }else if (candidate == num){
                count = count +1;
            }else{
                count = count -1;
            }
        }
        return candidate;
    }


    public static void main(String args[]){
        int[] nums = {7, 7, 5, 7, 5, 1 , 5, 7 ,5, 5, 7, 7 , 5, 7, 7, 5};
        System.out.println(majorityElement(nums));
    }

}