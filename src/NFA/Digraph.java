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
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E =0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v= 0; v<V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v ,int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for(int v=0;v<V;v++){
            for(int w:adj(v)){
                R.addEdge(w,v);
            }
        }
        return R;
    }


}