package LeetCode;

public class SortList_148 {
	
	/*
	 * use merge sort to get the list sorted
	 * 
	 */

	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val=x;
			next =null;
		}
	}

	
	public static ListNode sortList(ListNode head){
		
		if(head==null || head.next==null)
		{
			return head;
		}
		
		ListNode a = head;
		ListNode b = head.next;
		
		/*
		 * 找到指针中间节点，在此处将链表一分为二。
		 * 
		 * 两个指针调试往后移动，一个移动一步，一个移动两步。
		 * 当移动两步的指针移至末尾时候，head移至链表中间
		 */
		
		while((b!=null) && (b.next!=null))
		{
			head= head.next;
			b=b.next.next;
		}
		
		b=head.next; head.next=null;
		
		
		return merge(sortList(a),sortList(b));
		
	}
	
	public static ListNode merge(ListNode a,ListNode b)
	{
		ListNode head=new ListNode(0);
		
		ListNode c = head;
		
		while((a!=null)&&(b!=null))
		{
			if(a.val<b.val)
			{
				c.next= a; c = a;a=a.next;
			}else{
				c.next=b;  c = b;b=b.next;
			}
		}
		
		if(a==null)
		{
			c.next=b;
		}else{
			c.next=a;
		}
		
		return head.next;
	}
}
