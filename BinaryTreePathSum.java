package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;



public class BinaryTreePathSum {


	
	
	public static class TreeNode {
	   int val;
	   TreeNode left;
	   TreeNode right;
	   TreeNode(int x) { val = x; }
	   
	}
	
	  

	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	
    	// null point and iteration abort condition check
    	List<List<Integer>> result= new ArrayList<List<Integer>>();
    	if(root==null)
    	{
    		return result;
    	}
    	if(root.left==null && root.right==null)
    	{
    		if(root.val==sum)
    		{
    			List<Integer> arrayList = new ArrayList<Integer>();
    			arrayList.add(sum);
    			result.add(arrayList);
    		}    		
    		return result;
    	}
    	    	
    	List<List<Integer>> leftArray= pathSum(root.left,sum-root.val);
    	List<List<Integer>> rightArray = pathSum(root.right,sum-root.val);
    	
    	for(List<Integer> array: leftArray)
    	{
    		array.add(0, root.val);
    	}
    	
    	for(List<Integer> array: rightArray)
    	{
    		array.add(0, root.val);
    	}
    	
    	result.addAll(leftArray);
    	result.addAll(rightArray);
    	return result;
    	
    }
    
    public static void main(String[] args)
    {
    	
    	/*				5
    	 * 			   / \	
    	 *            4   8
    	 *           /   / \
    	 * 			11  13  4
    	 *         /  \    /  \
    	 *        7    2  5    1
    	 *         
    	 */  
    	
    	TreeNode root = new TreeNode(5);
    	
    }

}
