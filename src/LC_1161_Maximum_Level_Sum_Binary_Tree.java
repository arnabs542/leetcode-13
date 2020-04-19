/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/18
 */
public class LC_1161_Maximum_Level_Sum_Binary_Tree {
    /*

    https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/


     */
    public int maxLevelSum_BFS(TreeNode root) {
        int max = Integer.MIN_VALUE, maxLevel = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for(int level = 1;!q.isEmpty();++level){
            int sum = 0;
            for( int sz = q.size();sz>0;--sz){
                TreeNode n = q.poll();
                sum = sum + n.val;
                if( n.left!=null){
                    q.offer(n.left);
                }

                if( n.right != null){
                    q.offer(n.right);
                }
            }

            if( sum > max){
                max = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }


    public int maxLevelSum_DFS(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfs(root,list,0);

        return 1 + IntStream.range(0,list.size()).reduce(0,(a,b)-> list.get(a)<list.get(b)?b:a);

    }

    private void dfs(TreeNode n, List<Integer> l, int level){
        if(n==null){
            return ;
        }
        if(l.size() == level){
            l.add(n.val);
        }else{
            l.set(level,l.get(level)+n.val);
        }

        dfs(n.left,l,level+1);
        dfs(n.right,l,level+1);
    }






















}