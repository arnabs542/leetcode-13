/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/23
 */
public class LC_236_LCAOfBinaryTree {

    private TreeNode ans;

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
     }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root,p,q);
        return this.ans;
    }


    private boolean recurseTree(TreeNode currentNode,TreeNode p,TreeNode q){
        if(currentNode == null){
            return false;
        }

        int left = this.recurseTree(currentNode.left,p,q)?1:0;

        int right = this.recurseTree(currentNode.right,p,q)?1:0;

        int mid = (currentNode == p || currentNode == q) ?1:0;

        if(mid + left+right >=2){
            this.ans = currentNode;
        }

        return (mid + left + right >0);

    }


    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if( left!=null && right!=null){
            return root;
        }

        if(left!=null){
            return left;
        }

        if(right !=null){
            return right;
        }

        return null;

    }




















}