/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/28
 */
public class LC_210_Course_Schedule_Indegree {


    public int[] findOrder(int numCourses,int[][] prerequisites){
        boolean isPossible = true;
        Map<Integer,List<Integer>> adjList =new HashMap<Integer,List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];


        // Create the adjacency list representation of the graph

        for(int i = 0; i<prerequisites.length;i++){
            int dest = prerequisites[i][0];
            int src =prerequisites[i][1];

            List<Integer> lst = adjList.getOrDefault(src,new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
            indegree[dest] +=1;
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int i = 0;

        while(!q.isEmpty()){
            int node = q.remove();
            topologicalOrder[i++] = node;
            for(Integer neighbor: adjList.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }

        if(i == numCourses){
            return topologicalOrder;
        }

        return new int[0];
    }



}