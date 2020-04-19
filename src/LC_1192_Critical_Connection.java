/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/14
 */
public class LC_1192_Critical_Connection {

    /*

    https://leetcode.com/problems/critical-connections-in-a-network/

    https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/No-TarjanDFS-detailed-explanation-O(orEor)-solution-(I-like-this-question)

    https://leetcode.com/problems/critical-connections-in-a-network/discuss/399827/Java-DFS-Solution-similar-to-Tarjan-maybe-easier-to-understand



    First thought
    Thiking for a little while, you will easily find out this theorem on a connected graph:
    An edge is a critical connection, if and only if it is not in a cycle.
    So, if we know how to find cycles, and discard all edges in the cycles,
    then the remaining connections are a complete collection of critical connections.


     */
    int T = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(List<Integer> conn: connections){
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }

        int[] timestamp = new int[n];

        List<List<Integer>> criticalConns = new ArrayList<>();

        dfs(n,graph,timestamp,0,-1,criticalConns);

        return criticalConns;

    }



    private int dfs(int n ,List<Integer>[] graph,int[] timestamp,int i,
                    int parent, List<List<Integer>> criticalConns){
        if(timestamp[i] != 0){
            return timestamp[i];
        }
        timestamp[i] = T++;

        int minTimeStamp = Integer.MAX_VALUE;
        for(int neighbor: graph[i]){
            if(neighbor == parent){
                continue;
            }

            int neighborTimeStamp = dfs(n,graph,timestamp,neighbor,i,criticalConns);
            minTimeStamp = Math.min(minTimeStamp,neighborTimeStamp);
        }

        if(minTimeStamp >= timestamp[i]){
            if(parent >=0 ){
                criticalConns.add(Arrays.asList(parent,i));
            }
        }

        return Math.min(timestamp[i],minTimeStamp);
    }





















}