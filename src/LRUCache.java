

import java.util.HashMap;

public class LRUCache {
	
	public  class Node
	{
		public Node prev;
		public Node next;
		public int value;
		public int key;
		
		public Node(int key,int value)
		{
			this.key=key;
			this.value=value;
		}
				
	}
	
	Node head;
	Node tail;
	
	
	HashMap<Integer,Node> hashMap = new HashMap<Integer,Node>();
	final int capacity;
	int size=0;
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
    public int get(int key) {
    	if(hashMap.containsKey(key))
    	{
    		Node node= hashMap.get(key);
    		// to head 
    		
    		updateNode(node);    		
    		return node.value;
    		
    	}else{
    		return -1;
    	}
        
    }
    
    public void updateNode(Node node)
    {
    	deleteNode(node);
    	insertNode(node);
    }
    
    public void deleteNode(Node node)
    {
    	// 0 element
    	if(head==null && tail==null)
    	{
    		
    	}else if ( head ==tail ){ // 1 element
    		if(node ==tail)
    		{
    			head = tail = null;
    		}
    	}else if( node == tail) // node = tail 
    	{
    		node.prev.next=null;
    		tail = node.prev;
    	}else if( node == head) // node = head
    	{
    		node.next.prev=null;
    		head = node.next;
    	}else {
    		
    		node.prev.next = node.next;
    		node.next.prev = node.prev;
    	}

    }
    
    public void insertNode(Node node)
    {
    	if( head == null && tail == null)
    	{
    		head = tail = node;
    				
    	}else {
    		node.next = head;
    		head.prev=node;
    		head = node;    		
    	}
    }
        
    public void set(int key, int value) {
    	if(hashMap.containsKey(key))
    	{
    		Node node= hashMap.get(key);
    		
    		node.value = value;
    		updateNode(node);   		
    		hashMap.put(key, node);

    	}else{
    		if(size<capacity)
    		{
    			Node node = new Node(key,value);
    			
    			insertNode(node);		
    			size++;    	    			
    			hashMap.put(key,node);
    			
    		}else{
    			int oldestkey = tail.key;
    			hashMap.remove(oldestkey);
    			Node node = new Node(key,value);
    			hashMap.put(key, node);
    			// remove tail and insert to head
    			deleteNode(tail);
    			insertNode(node);
  			
    		}
    	}
        
    }
    
    public static void main(String[] args)
    {
    	LRUCache cache = new LRUCache(2);
    	
    	cache.set(2, 1);
    	cache.set(3, 2);
    	
    	cache.get(3);
    	
    	cache.get(2);
    	
    	cache.set(4, 3);
    	
    	cache.get(2);
    	cache.get(3);
    	cache.get(4);
    }
	

}
