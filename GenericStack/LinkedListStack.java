
public class LinkedListStack<T> implements StackInterface<T> {
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode (T data, ListNode link)
		{
			this.data = data;
			this.link = link;		
		}
	}
	private ListNode head;
	public LinkedListStack()
	{
		head = null;
	}
	public void push(T data)
	{
		ListNode newNode = new ListNode(data,head);
		head = newNode;
	}
	public T pop() 
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
		for(ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
}

