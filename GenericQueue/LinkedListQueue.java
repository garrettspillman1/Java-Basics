// Garrett Spillman
public class LinkedListQueue<T> implements QueueInterface<T> 
{
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T data,ListNode link)
		{
			this.data = data;
			this.link = link;
		}
	}
	private ListNode head;
	private ListNode tail;
	public LinkedListQueue() 
	{
		head = tail = null;
	}
	public void enqueue(T data)
	{
		ListNode newNode = new ListNode(data,null);
		if(head == null)
		{
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}
	public T dequeue()
	{
		if(head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}
	public T peek()
	{
		if(head == null)
			return null;
		return head.data;
	}
	public void print() 
	{
		for(ListNode temp = head; temp!=null; temp = temp.link)
			System.out.println(temp.data);
	}
	
}
