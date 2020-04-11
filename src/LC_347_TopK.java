/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/18
 */
public class LC_347_TopK {

    public List<Integer> topKFrequentByBucketSort(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer,Integer> frequencyMap = new HashMap<Integer,Integer>();
        for(int n: nums){
            frequencyMap.put(n,frequencyMap.getOrDefault(n,0)+1);
        }

        for(int key: frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<Integer>();
            }

            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<Integer>();

        for(int pos = bucket.length -1 ;pos >=0 && res.size() < k ;pos--){
            if(bucket[pos] !=null){
                res.addAll(bucket[pos]);
            }
        }


        return res;

    }




    public List<Integer> topKFrequentByPriorityQueue(int[] nums, int k) {

        HashMap<Integer,Integer> count  = new HashMap<Integer, Integer>();

        for(int n: nums){
            count.put(n,count.getOrDefault(n,0)+1);
        }


        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                ( n1,n2) -> count.get(n1) - count.get(n2));

        for( int n: count.keySet()){
            heap.add(n);
            if(heap.size()>k )
                heap.poll();
        }


        List<Integer> top_k = new LinkedList<>();

        while( !heap.isEmpty()){
            top_k.add(heap.poll());
        }

        Collections.reverse(top_k);
        return top_k;
    }
























}