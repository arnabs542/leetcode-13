package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrder_145 {


	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
//	  public static List<Integer> postorderTraversal(TreeNode root) {
//		  
//		  Stack<TreeNode> one  = new Stack<TreeNode>();
//		  
//		  Stack<TreeNode> two  = new Stack<TreeNode>();
//		  
//		  one.push(root);
//		  
//		  while(one.size()!=0)
//		  {
//			  TreeNode node = one.peek();
//			  
//			  if(node.left==null && node.right==null)
//			  {
//				  System.out.println(node.val);
//				  one.pop();
//			  }
//			  if(two.size()==0 ||one.peek()!=two.peek())
//			  {
//				  if(node.right!=null)
//				  {
//					  one.push(node.right);
//				  }
//				  if(node.left!=null)
//				  {
//					  one.push(node.left);
//					  two.push(node.left);
//				  }else{
//					  two.push(node.right);
//				  }
//			  }else{
//				  System.out.println(one.pop().val);
//				  two.pop(); 
//			  }
//
//
//		  }
//		  
//		  
//		  return new ArrayList<Integer>();
//	  }
	  

	  public static List<Integer> postorderTraversal(TreeNode root) 
	  {
		 return preOrderWithoutIteration(root);
		  
	  }
	  
	  
	  public static List<Integer> postOrderTraversal(TreeNode root)
	  {
		  List<Integer> list = new ArrayList<Integer>();
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  
		  stack.push(root);
		  TreeNode prev = null;
		  
		  while(!stack.isEmpty())
		  {
			  TreeNode cur = stack.peek();
			  
			  if( prev ==null || prev.left==cur || prev.right==cur)
			  {
				  if(cur.left !=null)
				  {
					  stack.push(cur.left);
				  }else if( cur.right!=null)
				  {
					  stack.push(cur.right);
				  }else{
					  list.add(cur.val);
					  System.out.println(cur.val);
					  stack.pop();
				  }
			  }else if( cur.left == prev) {
				  
				  if(cur.right!=null)
				  {
					  stack.push(cur.right);
				  }else{
					  
					  list.add(cur.val);
					  System.out.println(cur.val);
					  stack.pop();
				  }
				  
			  }else if ( cur.right == prev){
				  
				  list.add(cur.val);
				  System.out.println(cur.val);
				  stack.pop();
				  
			  }
			  
			  prev = cur;
		  }
		  
		  return list;
		  
	  }
	  
	  public static List<Integer> preOrderWithoutIteration(TreeNode node)
	  {
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  List<Integer> array = new ArrayList<Integer>();
		  stack.push(node);
		  while(!stack.isEmpty()){
			  TreeNode item= stack.pop();
			  if(item!=null){
				  
				  if(item.left!=null)
				  {
					  stack.add(item.left);
				  }
				  
				  if(item.right!=null)
				  {
					  stack.add(item.right);
				  } 
				  
				  array.add(item.val);			  		  

			  }		  
			  
		  }
		  
		  
		  Collections.reverse(array);
		  
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
		   * 
		   *   some explaination here,
		   *   the post order traversal ( left tree,right tree,root) can be seen the 
		   *   reverse of the preorder traversal ( root ,right tree, left tree)
		   *   take the right tree as example
		   *   the post order traversal is :
		   *   
		   *   3 4 2 6 5 0
		   *   
		   *   the preorder traversal is:
		   *   
		   *   0 5 6 2 4 3 
		   * 
		   *   so just reverse the result of the preorder we get post order
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

		  List<Integer> array = postOrderTraversal(root);
		  
		  for(Integer info: array)
		  {
			  System.out.println(info);
		  }
		  
		  System.out.println("----------------");

	  }
}
