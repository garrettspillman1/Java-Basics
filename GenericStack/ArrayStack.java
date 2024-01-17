public class ArrayStack<T> implements StackInterface<T> {
	private T[] stack;
	private int head; // first null element
	public static final int DEFAULT_SIZE = 100;
	
	public ArrayStack()
	{
		init(DEFAULT_SIZE);
	}
	public ArrayStack(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		head =  0;
		if(size >= 1)
			stack = (T[])(new Object[size]);
		else 
			stack = (T[])(new Object[DEFAULT_SIZE]);
	}
	public void push(T data)
	{
		if(head>=stack.length)
			return;
		stack[head] = data;
		head++;
	}
	public T pop() 
	{
		if(head == 0)
			return null;
		T ret = stack[head -1];
		head--;
		return ret;
	}
	public T peek()
	{
		if(head == 0)
			return null;
		return stack[head-1];
	}
	public void print()
	{
		for(int i = head-1;i>=0;i--)
			System.out.println(stack[i]);
	}
}
