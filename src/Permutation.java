
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static List<List<Integer>> permute(int[] num) {
    	
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	
    	if(num.length<2)
    	{
    		List<Integer> array = new ArrayList<Integer>();
    		array.add(num[0]);
    		list.add(array);
    		return list;
    	}    	

    	for(int i=0;i<num.length;i++)
    	{
    		int temp = num[i];
    		num[i]=num[0];    		
    		num[0]=temp;
    		
    		for(List<Integer> item: permute(Arrays.copyOfRange(num, 1,num.length)))
    		{
    			List<Integer> array = new ArrayList<Integer>();
    			array.add(num[0]);
    			array.addAll(item);
    			list.add(array);
    		}
    		
    		temp = num[i];
    		num[i]=num[0];    		
    		num[0]=temp;
    		
    	}
     	
    	return list;
    }
    
    public static void swap(int x ,int y)
    {
    	System.out.println(x+"\t"+y);
    	x = x^y;
    	y = x^y;
    	x = x^y;
    	System.out.println(x+"\t"+y);
    }
    
    public static void main(String[] args)
    {
    	
    	int x = 10, y=6;
    	
    	swap(x,y);
    	
    	int[] array = new int[]{2,1,3};
    	
    	List<List<Integer>> list = permute(array);
    	
    	for(List<Integer> item: list)
    	{
    		for(Integer integer: item)
    		{
    			System.out.print(integer);
    			
    		}    		
    		System.out.println();    		
    	}
    	
    }

}
