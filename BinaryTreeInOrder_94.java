package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrder_94 {

	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  
	  public static List<Integer> inOrderTraversal(TreeNode root)
	  {
		  List<Integer> list = new ArrayList<Integer>();
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  
		  TreeNode current = root;
		  while(true)
		  {
			  //循环将左子树压栈
			  while(current!=null)
			  {
				  stack.push(current);
				  current=current.left;
			  }
			  
			  //为空则跳出循环
			  if(stack.isEmpty())
			  {
				  break;
			  }else{
				 
				  //否则 弹出当前元素，并将当前元素的右子树压栈
				  TreeNode node= stack.pop();
				  list.add(node.val);
				  System.out.println(node.val);
				  
				  current=node.right;
			  }
			   
		  }

		  return list;
		  
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
		   * 
		   *   some explaination here,
		   *   
		   *   
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

		  List<Integer> array = inOrderTraversal(root);
		  
		  System.out.println("----------------");
		  
		  for(Integer info: array)
		  {
			  System.out.println(info);
		  }
		  
		  System.out.println("----------------");

	  }
}
