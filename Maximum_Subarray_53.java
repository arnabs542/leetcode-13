package leetcode;

public class Maximum_Subarray_53 {
	/**
	 *  用dp 递推关系式
	 *  
	 *  maxEndHere(以此i点为尾的最大值)
	 *  
	 *  maxToHere(遍历至此i点所遇到的最大值)
	 *  
	 *  
	 *  当遍历下一个元素时候，最大值的可能选项是：
	 *  
	 *  element[i]
	 *  
	 *  maxEndHere + element[i]
	 *  
	 *  maxToHere
	 * 
	 * 
	 *  当然每次新遍历新元素时候，除了更新maxToHere之外，还需要更新maxEndHere
	 *  
	 *  
	 *  可以参照 Jon Bentley的文章：algorithm design techniques
	 *	发表在
	 *  Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885
	 */
	
	public static int maxSubArray(int[] nums){
		int maxToHere=nums[0];
		int maxEndHere = nums[0];
		int i=0;
		for(i=1;i<nums.length;i++){
			maxEndHere=Math.max(nums[i], nums[i]+maxEndHere);
			maxToHere = Math.max(maxToHere, maxEndHere);
		}
		
		return maxToHere;
	}
	
	public static void main(String[] args){
		
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println("max\t"+maxSubArray(nums));
	}

}
