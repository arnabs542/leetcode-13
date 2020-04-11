/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/7
 */
public class LC_108_Convert_Array_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        TreeNode head  = helper(nums,0, nums.length-1);
        return head;
    }

    public TreeNode helper(int[] num,int low, int high){
        if(low>high){
            return null;
        }

        int mid = (low+high)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num,low,mid-1);
        node.right = helper(num,mid+1,high);
        return node;
    }
}