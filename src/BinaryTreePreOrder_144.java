package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrder_144 {
	
	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	  public static List<Integer> preOrderWithoutIteration(TreeNode root)
	  {
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  List<Integer> array = new ArrayList<Integer>();
		  stack.push(root);
		  while(!stack.isEmpty()){
			  TreeNode item= stack.pop();
			  if(item!=null){
				  
				  if(item.right!=null)
				  {
					  stack.add(item.right);
				  }
				  
				  if(item.left!=null)
				  {
					  stack.add(item.left);
				  } 
				  
				  array.add(item.val);			  		  

			  }		  
			  
		  }
		  return array;
		  
	  }
	  
	  public static void main(String[] args)
	  {
		  
		  /*
		   * 						0							0
		   * 					   / \						   / \ 	
		   * 					  2   5						  2   5
		   * 					/  \   \					 / \   \
		   * 				   3    4   6                   3   4  6
		   * 				  / \	/	 \
		   * 				 7	8   9    10
		   * 
		   * 		just as it is 
		   *   
		   * 
		   */
		  TreeNode root = new TreeNode(0);
		  root.left = new TreeNode(2);
		  root.right= new TreeNode(5);
		  
		  root.left.left = new TreeNode(3);
		  root.left.right = new TreeNode(4);
		  
		  root.right.right = new TreeNode(6);
		  
		  System.out.println("----------------");

		  List<Integer> array = preOrderWithoutIteration(root);
		  
		  System.out.println("----------------");
		  
		  for(Integer info: array)
		  {
			  System.out.println(info);
		  }
		  
		  System.out.println("----------------");

	  }

}
