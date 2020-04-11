package Algorithm;/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/23
 */
public class LC_236_LCAOfBinaryTree_Parent_Pointer {

    private TreeNode ans;

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
     }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        Map<TreeNode,TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if( node.left != null){
                parent.put(node.left,node);
                stack.push(node.left);
            }

            if(node.right!=null){
                parent.put(node.right,node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();

        while(p!=null){
            ancestors.add(p);
            p = parent.get(p);
        }

        while(!ancestors.contains(q)){
            q = parent.get(q);
        }

        return q;
    }





















}