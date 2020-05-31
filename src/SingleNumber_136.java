public class SingleNumber_136 {

	public static int singleNumber(int[] A){
		if(A.length%2==0)
		{
			return -1;
		}
		if(A.length==1)
		{
			return A[0];
		}
		
		int result = A[0];
		
		for(int i=1;i<A.length;i++)
		{
			result=result^A[i];
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args)
	{
		
		int[] array = new int[]{1,2,2};
		
		int result = singleNumber(array);
		
		System.out.println(result);

	}

}
