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
public class LC_235_Lowest_Common_Ancestor_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(pVal > parentVal && qVal > parentVal){
            return lowestCommonAncestor(root.right,p,q);
        }else if ( pVal < parentVal && qVal < parentVal){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }
























}