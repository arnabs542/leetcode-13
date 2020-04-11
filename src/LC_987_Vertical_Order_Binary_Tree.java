/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/8
 */
public class LC_987_Vertical_Order_Binary_Tree {
    List<Location> locations = new ArrayList();
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        dfs(root, 0, 0);
        Collections.sort(locations);

        List<List<Integer>> ans = new ArrayList();

        ans.add(new ArrayList<Integer>());
        int prev = locations.get(0).x;

        for(Location loc: locations){
            if(loc.x != prev){
                prev = loc.x;

                ans.add(new ArrayList<Integer>());
            }

            ans.get(ans.size()-1).add(loc.val);
        }

        return ans;
    }


    public void dfs(TreeNode node,int x,int y){
        if(node != null){
            locations.add(new Location(x, y, node.val));
            dfs(node.left,x-1,y);
            dfs(node.right,x+1,y+1);
        }
    }



    class Location implements Comparable<Location>{
        int x, y, val;
        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x)
                return Integer.compare(this.x, that.x);
            else if (this.y != that.y)
                return Integer.compare(this.y, that.y);
            else
                return Integer.compare(this.val, that.val);
        }
    }


    /*

    https://www.programcreek.com/2014/04/leetcode-binary-tree-vertical-order-traversal-java/

     */


    /*

    https://www.geeksforgeeks.org/print-binary-tree-vertical-order/

    https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/

    https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/


     */

    /*

    https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/?currentPage=1&orderBy=most_votes&query=


     */


    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
            dfs(root, 0, 0, map);
            List<List<Integer>> list = new ArrayList<>();
            for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
                list.add(new ArrayList<>());
                for (PriorityQueue<Integer> nodes : ys.values()) {
                    while (!nodes.isEmpty()) {
                        list.get(list.size() - 1).add(nodes.poll());
                    }
                }
            }
            return list;
        }
        private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
            if (root == null) {
                return;
            }
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(root.val);
            dfs(root.left, x - 1, y + 1, map);
            dfs(root.right, x + 1, y + 1, map);
        }
    }
}
