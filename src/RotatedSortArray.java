package LeetCode;

import java.util.Arrays;

public class RotatedSortArray {
	
	
    public static int findMin(int[] num) {
    	
    	// illeagle argument check
    	if(num.length<1)
    	{
    		return -1;
    	}
    	
    	// iteration abort check
    	if(num.length==1)
    	{
    		return num[0];
    	}
    	
    	if(num.length==2)
    	{
    		return num[0]>num[1]?num[1]:num[0];
    	}
    	    	
    	int middle = num.length/2;
    	
    	int povit = num[middle];
    	
    	// 0 1 2 3 4 5 6 7
    	// 6 7 0 1 2 3 4 5 
    	// 3 4 5 6 7 0 1 2 
    	
    	int first = num[0];
    	
    	int end = num[num.length-1];
    	
    	// check whether the array is rotated ,if first > end is rotated ,otherwise not rotated
    	
    	if(first>end)
    	{
        	if(povit > first)
        	{
        		return findMin(Arrays.copyOfRange(num, middle, num.length));
        	}else{
        		return findMin(Arrays.copyOfRange(num, 0, middle+1));
        	}
    	}else{
    		 return findMin(Arrays.copyOfRange(num, 0, middle+1));
    	}
    }
    
    public static void main(String[] args)
    {
//    	int[] num = new int[]{ 6,7,0, 1, 2, 3, 4, 5};
//    	int[] num = new int[]{1,2,3};
    	
    	int[] num = new int[]{3,3,1};
    	System.out.println(findMin(num));
    	
    	
    	
    }



}
