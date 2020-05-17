package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition_132 {
	

    public static List<List<String>> partition(String s) {
    	    	
    	List<List<String>> list = new ArrayList<List<String>>();
    	
    	if(s.length()<=0)
    	{
    		List<String> array = new ArrayList<String>();
    		list.add(array);
    		return list;
    	}
    	
    	for(int i=1;i<s.length()+1;i++)
    	{
    		if(isPalindronme(s.substring(0, i)))
    		{

    			
        		for(List<String> item: partition(s.substring(i)))
        		{
        			List<String> array = new ArrayList<String>();
        			array.add(s.substring(0,i));
        			
        			array.addAll(item);
        			
        			list.add(array);
        		}
    			
    		}
    	}
    	
        return list;
    }
    
    
    public static boolean isPalindronme(String s)
    {
    	if(s==null)
    	{
    		return true;
    	}
    	
    	int i = 0,j = s.length()-1;
    	
    	for(;i<=j;)
    	{
    		if(s.charAt(i)==s.charAt(j))
    		{
    			i++;
    			j--;
    		}else{
    			return false;
    		}
    	}
    	
    	return true;
    	
    }
    
    public static void main(String[] args)
    {
    	
    	List<List<String>> partitions = partition("cdd");
    	
    	for(List<String> item: partitions)
    	{
    		for(String s: item)
    		{
    			System.out.print(s+"\t");
    			
    		}    		
    		System.out.println();    		
    	}
    	
    	System.out.println("end");
    }

}
