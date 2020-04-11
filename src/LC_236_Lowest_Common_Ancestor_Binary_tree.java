/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/11
 */
public class LC_236_Lowest_Common_Ancestor_Binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);

        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if( left!=null && right!=null){
            return root;
        }else if (left==null){
            return right;
        }else {
            return left;
        }
    }




















}