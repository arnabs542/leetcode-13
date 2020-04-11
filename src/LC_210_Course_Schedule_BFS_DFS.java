/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/28
 */
public class LC_210_Course_Schedule_BFS_DFS {



    public int[] findOrder(int numCourses,int[][] pre){
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);

        initialGraph(incLinkCounts,adjs,pre);

        return solveByDFS(adjs);
        // return solveByBFS(incLinkCounts,adjs);
    }

    private void initialGraph(int[] incLinkCounts,List<List<Integer>> adjs,
                              int[][] pre){
        int n = incLinkCounts.length;

        while(n-->0) adjs.add(new ArrayList<>());
        for(int[] edge:pre){
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }


    private int[] solveByBFS(int[] incLinkCounts,
                             List<List<Integer>> adjs){
        int[] order = new int[incLinkCounts.length];

        Queue<Integer> toVisit = new ArrayDeque<>();
        for(int i =0; i<incLinkCounts.length;i++){
            if(incLinkCounts[i] == 0){
                toVisit.offer(i);
            }
        }

        int visited = 0;
        while(!toVisit.isEmpty()){
            int from = toVisit.remove();

            order[visited++] = from;

            for(int to: adjs.get(from)){
                incLinkCounts[to]--;
                if(incLinkCounts[to] == 0){
                    toVisit.add(to);
                }
            }
        }

        return visited == incLinkCounts.length?order:new int[0];

    }


    private int[] solveByDFS(List<List<Integer>> adjs){
        BitSet hasCycle = new BitSet(1);
        BitSet visited = new BitSet(adjs.size());
        BitSet onStack = new BitSet(adjs.size());

        Deque<Integer> order =new ArrayDeque<>();
        for(int i = adjs.size()-1;i>=0;i--){
            if(visited.get(i) == false &&
                    hasOrder(i,adjs,visited,onStack,order) == false)
                return new int[0];
        }

        int[] orderArray = new int[adjs.size()];

        for(int i = 0 ;!order.isEmpty();i++){
            orderArray[i] = order.pop();
        }
        return orderArray;
    }


    private boolean hasOrder(int from,List<List<Integer>> adjs,
                             BitSet visited,
                             BitSet onStack,Deque<Integer> order){

        visited.set(from);
        onStack.set(from);

        for( int to: adjs.get(from)){
            if(visited.get(to) == false){
                if(hasOrder(to,adjs,visited,onStack,order) == false){
                    return false;
                }
            }else if( onStack.get(to) ==true){
                return false;
            }
        }

        onStack.clear(from);
        order.push(from);
        return true;
    }



}