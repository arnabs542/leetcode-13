/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/12
 */
public class LC_973_K_Closest_Points_To_Origin {

    /*

    https://leetcode.com/problems/k-closest-points-to-origin/solution/

    https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.

    */


    public int[][] kClosest_Sort(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }


    public int[][] kClosest_Priority_queue(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }




}