/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/15
 */
public class LC_133_CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    }

    public static HashMap<Integer,Node> graphNodeMap = new HashMap<Integer, Node>();

    public Node cloneGraph(Node node){
        if(node == null){
            return null;
        }

        if(graphNodeMap.containsKey(node.val)){
            return graphNodeMap.get(node.val);
        }
        Node copy = new Node(node.val);

        graphNodeMap.put(copy.val,copy);


        for(Node neigh: node.neighbors){
            Node neighCopy = cloneGraph(neigh);

                copy.neighbors.add(neighCopy);
        }

        return copy;
    }
}