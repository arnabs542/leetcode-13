/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/12
 */
public class LC_1319_Number_Operation_Make_Network_Connected {
    /*
     https://leetcode.com/problems/number-of-operations-to-make-network-connected/


    https://leetcode.com/problems/number-of-operations-to-make-network-connected/discuss/477677/Java-Union-Find-(count-components-and-extra-edges)

     */

    public static int findParent(int[] par, int i){
        if(par[i] == i ){
            return i;
        }

        return par[i] = findParent(par,par[i]);
    }

    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        int m = connections.length;

        int components = 0;
        int extraEdge = 0;

        for(int i=0;i<m;i++){
            int p1 = findParent(parent,connections[i][0]);
            int p2 = findParent(parent,connections[i][1]);
            if(p1 == p2){
                extraEdge ++;
            }else{
                parent[p1] = p2;
            }
        }

        for( int i =0; i<n;i++){
            if(parent[i] == i){
                components++;
            }
        }

        return ( extraEdge>= components-1) ? components-1:-1;
    }



    /*
    https://leetcode.com/problems/number-of-operations-to-make-network-connected/discuss/477679/Python-Count-the-Connected-Networks


    We need at least n - 1 cables to connect all nodes (like a tree).
    If connections.size() < n - 1, we can directly return -1.

    One trick is that, if we have enough cables,
    we don't need to worry about where we can get the cable from.

    We only need to count the number of connected networks.
    To connect two unconneccted networks, we need to set one cable.

    The number of operations we need = the number of connected networks - 1


    Complexity
    Time O(connections)
    Space O(n)


     def makeConnected(self, n, connections):
        if len(connections) < n - 1: return -1
        G = [set() for i in xrange(n)]
        for i, j in connections:
            G[i].add(j)
            G[j].add(i)
        seen = [0] * n

        def dfs(i):
            if seen[i]: return 0
            seen[i] = 1
            for j in G[i]: dfs(j)
            return 1

        return sum(dfs(i) for i in xrange(n)) - 1






    def makeConnected(self, n, connections):
        if len(connections) < n - 1:
            return -1
        s = ''.join(map(chr, range(n)))
        for a, b in connections:
            s = s.replace(s[a], s[b])
        return len(set(s)) - 1


     */




















}