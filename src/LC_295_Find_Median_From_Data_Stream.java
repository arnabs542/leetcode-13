/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/11
 */
public class LC_295_Find_Median_From_Data_Stream {
    /*

    https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/


     */
    class MedianFinder {
        // max queue is always larger or equal to min queue
        PriorityQueue<Integer> min = new PriorityQueue();
        PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());


        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {

            max.offer(num);

            min.offer(max.poll());

            if(max.size() < min.size()){
                max.offer(min.poll());
            }

        }

        public double findMedian() {
            if(max.size() == min.size()){
                return (max.peek() + min.peek())/2.0;
            }else{
                return max.peek();
            }

        }
    }

















}