// Garrett Spillman
public class ArrayQueue<T> implements QueueInterface<T>
{
	private T[] queue;
	private int headIndex; // first index
	private int tailIndex; // first null element// 1 past last element
	public static final int DEFAULT_SIZE = 100;
	public ArrayQueue()
	{
		init(DEFAULT_SIZE);
	}
	public ArrayQueue(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		headIndex = tailIndex = 0;
		if(size >= 1)
			queue = (T[])(new Object[size]);
		else 
			queue = (T[])(new Object[DEFAULT_SIZE]);
	}
	public void enqueue(T data)
	{
		if(queue[headIndex] != null && headIndex == tailIndex)
			return;
		queue[tailIndex] = data;
		tailIndex =(tailIndex+1)%queue.length;
	}
	public T dequeue() 
	{
		T ret= queue[headIndex];
		headIndex =(headIndex+1)%queue.length;
		return ret;
	}
	public T peek()
	{
		return queue[headIndex];
	}
	public void print()
	{
		System.out.println(queue[headIndex]);
		for(int i = (headIndex+1)%queue.length; i != tailIndex; i = (i+1)%queue.length)
		{
			System.out.println(queue[i]);
		}
	}
}
