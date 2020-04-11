/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/8
 */
public class LC_102_Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root==null){
            return wrapList;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i = 0;i<levelNum;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }

                subList.add(queue.poll().val);
            }

            wrapList.add(subList);
        }

        return wrapList;

    }




    public List<List<Integer>> levelOrder_DFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }


    public void levelHelper(List<List<Integer>> res, TreeNode root,int height){
        if( root == null){
            return;
        }

        if(height>= res.size()){
            res.add(new LinkedList<Integer>());
        }

        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res,root.right,height+1);
    }


    /*

    https://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-ii-java/
     */
    public ArrayList<ArrayList<Integer>> levelOrder_BFS_2(TreeNode root) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        if(root == null)
            return al;

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);

        while(!current.isEmpty()){
            TreeNode node = current.remove();

            if(node.left != null)
                next.add(node.left);
            if(node.right != null)
                next.add(node.right);

            nodeValues.add(node.val);
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<TreeNode>();
                al.add(nodeValues);
                nodeValues = new ArrayList();
            }

        }
        return al;
    }

}