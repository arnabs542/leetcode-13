/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Arrays;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/24
 */
public class LC_315_Count_Smaller_Number_After_Self_BST {


    /**
     *     The smaller numbers on the right of a number are exactly
     *     those that jump from its right to its left during a stable sort.
     *     So I do mergesort with added tracking of those right-to-left jumps.
     */

    class Node{
        Node left,right;
        int val,sum ,dup = 1;

        public Node(int v,int s){
            val = v;
            sum = s;
        }
    }





    public List<Integer> countSmaller(int[] nums){
        Integer[] ans = new Integer[nums.length];
        Node root = null;

        for(int i = nums.length-1;i>=0;i--){
            root = insert(nums[i],root,ans,i,0);
        }

        return Arrays.asList(ans);
    }

    private Node insert( int num, Node node, Integer[] ans ,int i,int preSum){
        if(node == null){
            node = new Node(num,0);
            ans[i] = preSum;
        }else if ( node.val == num){
            node.dup ++;
            ans[i] = preSum + node.sum;
        }else if (node.val > num){
            node.sum ++;
            node.left = insert(num,node.left,ans,i,preSum);
        }else{
            node.right = insert(num,node.right,ans,i,preSum + node.dup + node.sum);

        }
        return node;
    }









}