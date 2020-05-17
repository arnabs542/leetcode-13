

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
	
	public static class Node
	{
		int value;
		
		public Node(int value)
		{
			this.value=value;
		}
		
	}

	public static void main(String[] args)
	{
		LinkedList<Node> list = new LinkedList<Node>();
		
		list.add(new Node(5));
		list.add(new Node(6));
		list.add(new Node(7));
		list.add(new Node(8));
		
		ListIterator<Node> i = list.listIterator();
		while(i.hasNext())
		{
			System.out.println(i.next().value);
		}
	}

}
