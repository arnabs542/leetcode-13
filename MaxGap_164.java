package LeetCode;

import java.util.BitSet;

public class MaxGap_164 {
	
	/*
	 *  we just use the bit array to encode 
	 *  
	 *  the input num array
	 *  
	 *  
	 *  then we just iterate the bit array 
	 *  
	 *  to get the max gap
	 * 
	 * 
	 * 
	 */
	
    public static int maximumGap(int[] num) {
    	
    	if(num.length<2)
    	{
    		return 0;
    	}
    	
       	BitSet set = new BitSet();
    	
    	for(int a: num)
    	{
    		set.set(a);
    	}
    	
    	System.out.println(set.size());
    	int prev=0;
    	
    	int maxGap=0;
    	
    	for (int i = set.nextSetBit(0); i >= 0; i = set.nextSetBit(i+1)) {
    		
    		int distance = i-prev;
    		
    		maxGap = Math.max(maxGap, distance);
    		
    		prev = i;
    		
    	}
    	
    	
    	
    	return maxGap;
        
    }
    
    
    public static void main(String[] args)
    {
    	
    	int[] num = new int[]{1,200,2000000000,3};
    	
    	int maxGap = maximumGap(num);
    	
    	System.out.println(maxGap);
    	
    	
    }
    
}
