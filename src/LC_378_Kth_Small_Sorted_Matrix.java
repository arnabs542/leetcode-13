/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.PriorityQueue;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/24
 */
public class LC_378_Kth_Small_Sorted_Matrix {
    class Tuple implements Comparable<Tuple> {
        int x,y,val;
        public Tuple(int x ,int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        for(int j =0;j<matrix[0].length;j++){
            pq.offer(new Tuple(0,j,matrix[0][j]));
        }

        for(int i=0;i<k-1;i++){
            Tuple t = pq.poll();
            if(t.x == n-1){
                continue;
            }

            pq.offer(new Tuple(t.x+1,t.y,matrix[t.x+1][t.y]));
        }

        return pq.poll().val;
    }

























}