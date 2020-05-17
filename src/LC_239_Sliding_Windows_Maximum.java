/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/20
 */
public class LC_239_Sliding_Windows_Maximum {
    /*

    https://leetcode.com/problems/sliding-window-maximum/


     */
    public int[] maxSlidingWindow(int[] a, int k) {
        if( a == null || k <= 0){
            return new int[0];
        }

        int n = a.length;

        int[] r = new int[n-k+1];

        int ri = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<a.length;i++){
            while( !q.isEmpty() && q.peek() < i-k+1){
                q.poll();
            }

            while(!q.isEmpty() && a[q.peekLast()] < a[i]){
                q.pollLast();
            }

            q.offer(i);

            if( i >= k-1){
                r[ri++] = a[q.peek()];
            }
        }

        return r;
    }





















}