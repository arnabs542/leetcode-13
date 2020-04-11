/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/28
 */
public class LC_210_Course_Schedule_DFS {

    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<Integer,Integer> color;
    Map<Integer,List<Integer>> adjList;
    List<Integer> topologicalOrder;


    private void init (int numCourses){
        this.isPossible = true;
        this.color = new HashMap<Integer,Integer>();
        this.adjList = new HashMap<Integer,List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();

        for(int i=0;i<numCourses;i++){
            this.color.put(i,WHITE);
        }
    }


    private void dfs(int node){
        if(!this.isPossible){
            return;
        }

        this.color.put(node,GRAY);

        for(Integer neighbor: this.adjList.getOrDefault(node,new ArrayList<>())){
            if(this.color.get(neighbor) == WHITE){
                this.dfs(neighbor);
            }else if (this.color.get(neighbor) == GRAY){
                // An edge to a GRAY vertex represents a cycle
                this.isPossible = false;
            }
        }

        this.color.put(node,BLACK);
        topologicalOrder.add(node);

    }


    public int[] findOrder(int numCourses,int[][] pre){
        this.init(numCourses);

        // Create the adjacency list representation of the graph

        for(int i = 0; i<pre.length;i++){
            int dest = pre[i][0];
            int src =pre[i][1];

            List<Integer> lst = adjList.getOrDefault(src,new ArrayList<>());
            lst.add(dest);
            adjList.put(src,lst);
        }


        for(int i=0;i<numCourses;i++){
            if(this.color.get(i) == WHITE){
                dfs(i);
            }
        }

        int[] order;

        if(this.isPossible){
            order = new int[numCourses];
            for(int i =0;i<numCourses;i++){
                order[i] = this.topologicalOrder.get(numCourses-i-1);
            }
        }else{
            order = new int[0];
        }

        return order;
    }

}