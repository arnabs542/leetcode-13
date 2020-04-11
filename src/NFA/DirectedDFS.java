/*
 * Copyright (c) 2018 maoyan.com
 * All rights reserved.
 *
 */
package NFA;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 18/7/6
 */
public class DirectedDFS {
    private boolean[] marked;
    // find vertices in G that are reachable from s
    public DirectedDFS(Digraph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    // find vertices in G that are reachable from sources
    public DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for( int s: sources){
            if(!marked[s]){
                dfs(G,s);
            }
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }
    // is v reachable
    boolean marked(int v){
        return marked[v];
    }


}