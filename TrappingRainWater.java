package LeetCode;

import java.util.Arrays;

public class TrappingRainWater {

	/*
	 *  we get the start and end of the trap
	 *  
	 *  first round get the start,
	 *  
	 *  second get the end.
	 *  
	 *  类似于判断波峰和波谷
	 *  
	 *  需要找两个局部的最大点和最小点
	 *  
	 *  maxstart
	 *  -------- 			maxend
	 *  
	 *  					-----------
	 *  		 minvalue
	 * 			-----------
	 * 
	 * 然后在此基础上循环递归即可完成。
	 */
    public static int trap(int[] A) {
    	if(A.length<3)
    	{
    		return 0;
    	}
    	
    	/*
    	 * first we iterate to get the first local maximum value
    	 * 
    	 * if we get to the end ,we just return 0
    	 */
    	
    	int maxStart=A[0];
    	int index = 0;
    	for(;index<A.length&&A[index]>=maxStart;index++)
    	{
    		maxStart=A[index];

    	}
    	// check
    	if(index==A.length)
    	{
    		return 0;
    	}
    	
    	int secondIndex = index;
    	int minStart = A[index];
    	
    	for(;secondIndex<A.length;secondIndex++)
    	{
    		if(A[secondIndex]<=minStart)
    		{
    			minStart = A[secondIndex];
    		}else{
    			break;
    		}
    		
    	}
    	
    	
    	if(secondIndex==A.length)
    	{
    		return 0;
    	}
    	
    	
    	int thirdIndex = secondIndex-1;
    	int maxSecond = A[thirdIndex];
    	thirdIndex++;
    	boolean thirdStep=false;
    	for(;thirdIndex<A.length;thirdIndex++)
    	{
    		if(A[thirdIndex]>maxSecond)
    		{
    			maxSecond = A[thirdIndex];
    			thirdStep=true;
    		}else{
    			break;
    		}
    		
    	}
    	
    	int max = maxStart>maxSecond?maxSecond:maxStart;
    	
    	int sum=0;
    	
    	int end ;
    	if(thirdStep==true)
    	{
    		end = thirdIndex-2;
    	}else{
    		end = thirdIndex-1;
    	}

    	for(int i=index;i<=end;i++)
    	{
    		if(A[i]>=max)
    		{
    			
    		}else{
    			sum = sum + max -A[i];
    		}
    	    		
    	}
    	
//    	System.out.println("sum="+sum+"\tindex="+index+"\t"+"endIndex="+(thirdIndex-1)+"\t"+"max="+max+"\tmin="+minStart);

    	return sum+trap(Arrays.copyOfRange(A,thirdIndex-1,A.length));
    	       
    }
    
    
    public static void main(String[] args)
    {
    	
//    	int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    	
    	int[] A = new int[]{5,4,1,2};
    	System.out.println(trap(A));
    }
    
    
    

}
