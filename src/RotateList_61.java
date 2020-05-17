package LeetCode;


public class RotateList_61 {
	
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val=x;
			next =null;
		}
	}

    public static  ListNode rotateRight(ListNode head, int n) {
    	
    	if(head==null)
    	{
    		return head;
    	}
    	
    	
    	
    	int length=0;
    	
    	ListNode temp = head;
    	
    	while(temp!=null)
    	{
    		length++;
    		temp=temp.next;
    	}
    	
    	
    	int rotate = n%length;
    	
    	ListNode step1 =head;
    	ListNode step2 =head;
    	for(;rotate>0;rotate--)
    	{
    		step1=step1.next;
    	}
    	
    	while(step1.next!=null)
    	{
    		step1=step1.next;
    		step2=step2.next;
    	}
    	
    	step1.next=head;
    	
    	head = step2.next;
    	step2.next=null;
    	
    	return head;
    }
    
    public static void main(String[] args)
    {
    	ListNode head = new ListNode(1);
    	
    	ListNode rotate = rotateRight(head,0);
    	
    	System.out.print("rotate"+rotate);
    	
    }

}
