/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Map;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/3
 */
public class LC_105_Binary_Tree_From_Preorder_Inorder {

    /**
     *
     Say we have 2 arrays, PRE and IN.
     Preorder traversing implies that PRE[0] is the root node.
     Then we can find this PRE[0] in IN, say it's IN[5].
     Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
     Recursively doing this on subarrays, we can build a tree out of it :)

     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
    }

    public TreeNode helper(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
        if(preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0; // index of the current root in inorder

        for( int i = inStart;i<=inEnd;i++){
            if(inorder[i] == root.val){
                inIndex = i;
            }
        }

        root.left = helper(preStart+1,inStart,inIndex-1,preorder,inorder);
        root.right = helper(preStart+inIndex - inStart+1,inIndex+1,inEnd,preorder,inorder);
        return root;
    }


    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }



}