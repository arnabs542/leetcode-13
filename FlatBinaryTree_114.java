package LeetCode;

import java.util.Stack;

public class FlatBinaryTree_114 {

	  public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	  }

	  static TreeNode temp ;
	  
	  
	  public static void preOrderWithoutIteration(TreeNode node)
	  {
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  stack.push(node);
		  TreeNode temp=null;
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
				  
				  if(temp ==null)
				  {
					  temp=item;
					  
				  }else{
					  temp.right = item;
					  temp = item;
				  }
				  System.out.println(item.val);
				  		  
 
			  }		  
			  
		  }
		  
	  }
	  
	  
	  public static void preOrderIteration(TreeNode node)
	  {
		  if(node==null)
		  {
			  return;
		  }
		  
		  TreeNode left = node.left;
		  TreeNode right = node.right;
		  if(temp==null)
		  {
			  temp = node;
			  node.left = null;
			  
		  }else{
			  temp.right = node;
			  temp = node; 
			  temp.left=null;
		  }

		  System.out.println(node.val);
		  preOrderIteration(left);
		  preOrderIteration(right);
		  
	  }
	   
	  
	    public static void flatten(TreeNode root) {
	    	
			  preOrderIteration(root);
//	    	preOrderWithoutIteration(root);
	        
	    }
	  
	  public static void main(String[] args)
	  {
		  TreeNode root = new TreeNode(0);
		  root.left = new TreeNode(2);
		  root.right= new TreeNode(5);
		  
		  root.left.left = new TreeNode(3);
		  root.left.right = new TreeNode(4);
		  
		  root.right.right = new TreeNode(6);
		  
		  System.out.println("----------------");
		  
		  preOrderWithoutIteration(root);
	  
		  System.out.println("----------------");
		  
//		  flatten(root);

		  System.out.println("----------------");
		  
		  
		  
		  
		  while(root!=null)
		  {
			  System.out.println(root.val);
			  root=root.right;
		  }
	  }
	  

}
