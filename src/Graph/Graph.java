/*
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 */
package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 19/4/27
 */
public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0 ;i <v; ++i){
            adj[i] = new LinkedList();
        }
    }


    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFSUtil(int v, final boolean visited[]){


        visited[v] = true;
        System.out.println(v + "");

        Iterator<Integer> iterator = adj[v].listIterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }

    void DFS(){
        boolean visited[] = new boolean[V];
        for(int i = 0; i<V; ++i){
            if(visited[i] == false){
                DFSUtil(i,visited);
            }
        }
    }

    void topologicalSortUtil(int v ,boolean visited[],
                             Stack stack){

        visited[v] = true;
        Integer i ;

        Iterator<Integer> it = adj[v].iterator();

        while(it.hasNext()){
            i = it.next();
            if(!visited[i]){
                topologicalSortUtil(i,visited,stack);
            }
        }

        stack.push(new Integer(v));

    }

    void topologicalSort(){

        Stack stack = new Stack();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
            visited[i] = false;

        for(int i=0;i<V;i++){
            if(visited[i] == false){
                topologicalSortUtil(i,visited,stack);
            }
        }
        while(stack.empty()==false){
            System.out.println(stack.pop()+"");
        }
    }

    void allTopologicalSortUtil(boolean[] visited,int[] indegree,
                                ArrayList<Integer> stack){
        boolean flag = false;

        for(int i=0;i<this.V; i++){
            if(!visited[i] && indegree[i] == 0){
                visited[i] = true;
                stack.add(i);

                for(int adjancent: this.adj[i]){
                    indegree[adjancent] --;
                }

                allTopologicalSortUtil(visited,indegree,stack);
            }
        }

    }


    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal");

        g.DFS();
    }












}

