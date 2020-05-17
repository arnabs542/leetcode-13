
public class MedianOfTwoSortedArray_4 {
	
	/*	
	 *  两种思路：
	 *  1.将中间值转换为求第kth值的元素。
	 *  2.领用divide and conqure方法，每次利用二分查找来剪枝，将查找范围缩小一半。
	 * 
	 */

	public static  double findMedianSortedArrays(int A[],int B[])
	{

		int len = A.length+B.length;
		
		if(len%2==0)
		{
			return (findKth(A,0,B,0,len/2)+findKth(A,0,B,0,len/2+1))/2.0;
		}else{
			return findKth(A,0,B,0,len/2+1);
		}
		
		
		
		
	}
	
	
	public static int findKth(int A[],int a_index,int B[], int b_index,int k)
	{
		if(a_index>=A.length)
		{
			return B[b_index+k-1];
		}
		
		if(b_index>=B.length)
		{
			return A[a_index + k-1];
		}
		
		if(k==1)
		{
			return Math.min(A[a_index], B[b_index]);
		}
		
		int Akey = a_index+k/2-1<A.length?A[a_index+k/2-1]:Integer.MAX_VALUE;
		int Bkey = b_index+k/2-1<B.length?B[b_index+k/2-1]:Integer.MAX_VALUE;
		
		if(Akey<Bkey)
		{
			// take caution: 
			return findKth(A,a_index+k/2,B,b_index,k-k/2);
		}else{
			return findKth(A,a_index,B,b_index+k/2,k-k/2);
		}
	}
	
	public static void main(String[] args)
	{
		int[] A = new int[]{1};
		
		int[] B = new int[]{2,3,4,5,6};
		
		double mid = findMedianSortedArrays(A,B);
		
		System.out.println(mid);
	}

}
