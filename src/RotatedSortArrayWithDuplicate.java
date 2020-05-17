

import java.util.Arrays;

public class RotatedSortArrayWithDuplicate {

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
    	    	
    	int middleindex = num.length/2;
    	int middlevalue = num[middleindex];
    	
    	// 0 1 2 3 4 5 6 7
    	// 6 7 0 1 2 3 4 5 
    	// 3 4 5 6 7 0 1 2 
    	
    	int first = num[0];
    	
    	int end = num[num.length-1];
    	
    
    	

    	
    	// check whether the array is rotated ,if first > end is rotated ,otherwise not rotated
    	if(first<end)
    	{
    		 return findMin(Arrays.copyOfRange(num, 0, middleindex+1));
    	}else{
    		
    		/*
    		 * 10 10 10 10 1 10 
    		 * 10 1 10 10 10 10 
    		 */
    		
    		if( middlevalue==first && middlevalue==end)
    		{
    			int leftRangeMin = findMin(Arrays.copyOfRange(num, 0, middleindex+1));
    			int rightRangeMin = findMin(Arrays.copyOfRange(num, middleindex, num.length));
    			return leftRangeMin>rightRangeMin?rightRangeMin:leftRangeMin;
    		}else{
    			
            	/*
            	 * 
            	 * some conclusions:
            	 * 
            	 * a ............c.............b
            	 * 
            	 * when min between a and c
            	 * 
            	 * we get min =<c <=b<=a , then we just search : a.....c
            	 * 
            	 * when min between c and b
            	 * 
            	 * we get min<=b<=a<=c ,then we just search c......b
            	 * 
            	 */
        		if((middlevalue<=first) && (middlevalue<=end))
        		{
        			return findMin(Arrays.copyOfRange(num, 0, middleindex+1));
        		}else{
        			return findMin(Arrays.copyOfRange(num, middleindex, num.length));
        		}
    			
    		}



    	}

    }
    
    public static void main(String[] args)
    {
//    	int[] num = new int[]{ 6,7,0, 1, 2, 3, 4, 5};
//    	int[] num = new int[]{1,2,3};
    	
//    	int[] num = new int[]{3,3,1};
    	
    	int[] num = new int[]{10,10,10,1,10};
    	System.out.println(findMin(num));
    	
    	
    	
    }

}
