package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph_133 {
	
	/**
	 * 
	 * 用一个表来记录已经访问过的节点
	 *
	 */
	
	
	public static class UndirectedGraphNode{
		
		int label;
		
		List<UndirectedGraphNode> neighbors;
		
		UndirectedGraphNode(int x){
			label=x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	
	static HashMap<Integer,UndirectedGraphNode> nodeMap = new HashMap<Integer,UndirectedGraphNode>();

	static HashSet<Integer> visitorNode = new HashSet<Integer>();
	
	static Queue<UndirectedGraphNode> iterateNode = new LinkedList<UndirectedGraphNode>();

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	
    	if(node==null)
    	{
    		return null;
    	}
    	
    	UndirectedGraphNode root =null;
    	
    	iterateNode.add(node);
    	
    	while(!iterateNode.isEmpty())
    	{
    		UndirectedGraphNode item = iterateNode.remove();  
    		
    		UndirectedGraphNode copyitem;
    		
			if(nodeMap.containsKey(item.label))
			{
				copyitem = nodeMap.get(item.label);
			}else{
				copyitem= new UndirectedGraphNode(item.label);
				nodeMap.put(item.label,copyitem);
			}
    		
    		List<UndirectedGraphNode> neighborList = new ArrayList<UndirectedGraphNode>();
    		for(UndirectedGraphNode neighor: item.neighbors)
    		{
    			
    			// 友邻从hashmap里面取，没有则创建新的数据。
    			UndirectedGraphNode copyNeighor;
    			if(nodeMap.containsKey(neighor.label))
    			{
    				copyNeighor = nodeMap.get(neighor.label);
    			}else{
    				copyNeighor= new UndirectedGraphNode(neighor.label);
    				nodeMap.put(neighor.label,copyNeighor);
    			}
    			 
    			
    			neighborList.add(copyNeighor);
    			
    			if(visitorNode.contains(copyNeighor.label))
    			{
    				
    			}else{
    				iterateNode.add(neighor);
    			}
    			
    		}
    		
    		copyitem.neighbors = neighborList;
    		
    		visitorNode.add(copyitem.label);
    		

    		if(root == null)
    		{
    			root = copyitem;
    		}
    		
    		
    	}
    	
    	
    	
    	
    	return root;
        
    }
    
    
    public static void main(String[] args){
    	
    	
    	UndirectedGraphNode node2 = new UndirectedGraphNode(2);
    	
    	List<UndirectedGraphNode> neighborList = new ArrayList<UndirectedGraphNode>();
    	neighborList.add(node2);
    	node2.neighbors = neighborList;
    	
    	
    	UndirectedGraphNode node1 = new UndirectedGraphNode(1);
    	
    	List<UndirectedGraphNode> neighborList1 = new ArrayList<UndirectedGraphNode>();
    	neighborList1.add(node2);
    	node1.neighbors = neighborList1;
    	
    	
    	UndirectedGraphNode node0 = new UndirectedGraphNode(0);
    	
    	List<UndirectedGraphNode> neighborList0= new ArrayList<UndirectedGraphNode>();
    	neighborList0.add(node1);
    	node0.neighbors = neighborList0;
    	
    	
    	UndirectedGraphNode copy = cloneGraph(node0);
    	
    	
        System.out.println("copy="+copy.label);

    	
    }
    
    

    

    
}
