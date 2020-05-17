

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache_V2 {

	LinkedList<Integer> list = new LinkedList<Integer>();
	HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
	final int capacity;
	int size=0;
	public LRUCache_V2(int capacity) {
		this.capacity = capacity;
	}
	
    public int get(int key) {
    	if(hashMap.containsKey(key))
    	{
    		
    		list.remove();
    		list.add(key);
    		return hashMap.get(key);
    	}else{
    		return -1;
    	}
        
    }
    
    public void set(int key, int value) {
    	if(hashMap.containsKey(key))
    	{
    		hashMap.put(key, value);
    	}else{
    		if(size<capacity)
    		{
    			size++;
    			hashMap.put(key,value);
    		}else{
    			int oldest = list.remove().intValue();
    			hashMap.remove(oldest);
    			hashMap.put(key, value);
    			list.add(key);    			
    		}
    	}
        
    }
    
    public static void main(String[] args)
    {
    	LRUCache_V2 cache = new LRUCache_V2(5);
    	
    	for(int i =0;i<=10;i++)
    	{
    		cache.set(i, i);
    	}
    	    	
    	for(int i = 5 ;i<=15;i++)
    	{
    		System.out.println(cache.get(i));
    	}
    }
	

}