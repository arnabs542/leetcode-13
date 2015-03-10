package LeetCode;


public class BinaryTreeMaxPath_124 {

	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  /*
	   *  大致思路 ：
	   *  
	   *  递归算法
	   *  
	   *  
	   *  已知左右子树的最大path值。
	   *  
	   *  其左子树，右子树 （从根至叶子节点的最大值）
	   *  
	   *  leftLeafMax, rightLeafMax,
	   *  
	   *  那么 其左右子树合并之后的最大值可能为：
	   *  
	   *  leftPathSum
	   *  
	   *  rightPathSum
	   *  
	   *  parent
	   *  
	   *  
	   *  
	   *  
	   * 
	   * 
	   */
	  public static int maxPathSum_2(TreeNode root) {
        
		  if(root==null)
		  {
			  return 0;
		  }
		  
		  
		  int maxleft = maxPathSum(root.left);
		  int maxright = maxPathSum(root.right);
		  
		
		  int value = root.val;
		  
		  int maxLeftLeafValue = rootToLeafMax(root.left);
		  int maxRightLeafValue = rootToLeafMax(root.right);
		  
		  int n1 = maxLeftLeafValue+value;
		  int n2 = maxLeftLeafValue+value+maxRightLeafValue;
		  int n3 = value+maxRightLeafValue;
		  
		  int[] array = new int[]{maxleft,maxright,value,maxLeftLeafValue,maxRightLeafValue,n1,n2,n3};
		  
		  int max=maxleft;
		  for(int i: array)
		  {
			  if(i>max)
			  {
				  max = i;
			  }
		  }
		  return max;
	  }
	  
	  public static int rootToLeafMax(TreeNode root)
	  {
		  if(root==null)
		  {
			  return 0;
		  }
		  int leftMax= rootToLeafMax(root.left);
		  int rightMax= rootToLeafMax(root.right);
		  int max = leftMax>rightMax?leftMax:rightMax;
		  return root.val+max;
	  }
	  
	  
	  public static int  maxValue;
	   public static int maxPathSum(TreeNode root) {
	        maxValue = Integer.MIN_VALUE;
	        maxPathDown(root);
	        return maxValue;
	    }

	    public static int maxPathDown(TreeNode node) {
	        if (node == null) return 0;
	        int left = Math.max(0, maxPathDown(node.left));
	        int right = Math.max(0, maxPathDown(node.right));
	        maxValue = Math.max(maxValue, left + right + node.val);
	        return Math.max(left, right) + node.val;
	    }
	  
	  public static void main(String[] args)
	  {
		  
		  TreeNode root = new TreeNode(-1);
		  
		  root.left = new TreeNode(-2);
		  root.right=new TreeNode(-3);
		  
		 System.out.println(maxPathSum(root));
		  
	  }
}
