/*
 * Copyright (c) 2018 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 18/5/10
 */
public class LC_572_SubTreeOfAnotherTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val =x;
        }
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubTree(TreeNode s,TreeNode t){
        return s!=null &&(isEqual(s,t) || isSubTree(s.left,t) || isSubTree(s.right,t));
    }

    public static boolean isEqual(TreeNode s,TreeNode t){
        if(s==null && t==null){
            return true;
        }
        if(s==null || t == null){
            return false;
        }

        return s.val == t.val && isEqual(s.left,t.left) && isEqual(s.right,t.right);
    }


}