/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Random;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/5
 */
public class LC_384_Shuffle_Array {

    class Solution {
        private int[] array;
        private int[] original;

        Random rand = new Random();

        private int randRange(int min,int max){
            return rand.nextInt(max-min) + min;
        }

        private void swapAt(int i,int j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }


        public Solution(int[] nums){
            array = nums;
            original = nums.clone();
        }


        /** Resets the array to its original configuration and return it. */
        public int[] reset() {

            array = original;
            original = original.clone();
            return original;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for(int i=0;i<array.length;i++){
                swapAt(i,randRange(i,array.length));
            }
            return array;
        }
    }

}