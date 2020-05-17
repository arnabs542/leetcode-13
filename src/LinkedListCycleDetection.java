package LeetCode;

public class LinkedListCycleDetection {
	
	
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }

	public static boolean hasCycle(ListNode head) {
		
		
		if(head==null || head.next==null || head.next.next==null)
		{
			return false;
		}

		
		ListNode one_step = head;
		
		ListNode two_step = head.next.next;
		
		while(one_step!=null && two_step!=null)
		{
			if(one_step==two_step)
			{
				return true;
			}else{
				if(two_step.next==null || two_step.next.next==null)
				{
					return false;
				}else{
					one_step= one_step.next;
					two_step= two_step.next.next;
				}
			}
		}

		return false;
        
    }
	
	public static void main(String[] args)
	{

		ListNode node = new ListNode(5);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(5);
		
		node.next = node2;
		
		node2.next=node3;
		
		node3.next=node4;
		node4.next=node5;
		
		node5.next=node;
		

		

	}

}
