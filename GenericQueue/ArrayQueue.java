/**
 * @garrettspillman1
 * 
 *                   A generic implementation of a queue using an array.
 *
 * @param <T> The type of elements stored in the queue.
 */
public class ArrayQueue<T> implements QueueInterface<T> {
	private T[] queue;
	private int headIndex; // Index of the first element
	private int tailIndex; // Index of the first null element (1 past the last element)
	public static final int DEFAULT_SIZE = 100;

	/**
	 * Constructs an ArrayQueue with the default size.
	 */
	public ArrayQueue() {
		init(DEFAULT_SIZE);
	}

	/**
	 * Constructs an ArrayQueue with a specified size.
	 *
	 * @param size The initial size of the queue.
	 */
	public ArrayQueue(int size) {
		init(size);
	}

	private void init(int size) {
		headIndex = tailIndex = 0;
		if (size >= 1)
			queue = (T[]) (new Object[size]);
		else
			queue = (T[]) (new Object[DEFAULT_SIZE]);
	}

	/**
	 * Adds an element to the end of the queue.
	 *
	 * @param data The data to be enqueued.
	 */
	public void enqueue(T data) {
		if (queue[headIndex] != null && headIndex == tailIndex)
			return;
		queue[tailIndex] = data;
		tailIndex = (tailIndex + 1) % queue.length;
	}

	/**
	 * Removes and returns the element at the front of the queue.
	 *
	 * @return The element removed from the front of the queue.
	 */
	public T dequeue() {
		T ret = queue[headIndex];
		headIndex = (headIndex + 1) % queue.length;
		return ret;
	}

	/**
	 * Returns the element at the front of the queue without removing it.
	 *
	 * @return The element at the front of the queue.
	 */
	public T peek() {
		return queue[headIndex];
	}

	/**
	 * Prints the elements in the queue.
	 */
	public void print() {
		System.out.println(queue[headIndex]);
		for (int i = (headIndex + 1) % queue.length; i != tailIndex; i = (i + 1) % queue.length) {
			System.out.println(queue[i]);
		}
	}
}
