/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package Offer;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/12
 */
public class Subtree_With_Maximum_Average {
    /*

    https://leetcode.com/discuss/interview-question/349617


     */

    double max = Integer.MIN_VALUE;

    TreeNode maxNode = null;

    public TreeNode maximumsAverageSubtree(TreeNode root){
        if ( root == null){
            return null;
        }

        helper(root);
        return maxNode;
    }

    private double[] helper(TreeNode root){
        if( root == null){
            return new double[]{0,0};
        }

        double curTotal = root.val;

        double count = 1;

        for(TreeNode child: root.children){
            double[] cur = helper(child);
            curTotal += cur[0];
            count += cur[1];
        }

        double avg = curTotal/count;

        if( count >1 && avg > max){
            max = avg;
            maxNode = root;
        }

        return new double[]{curTotal,count};
    }



























}