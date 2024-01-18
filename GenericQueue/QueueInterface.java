/**
 * @garrettspillman1
 *                   A generic interface for a queue.
 *
 * @param <T> The type of elements stored in the queue.
 */
public interface QueueInterface<T> {

	/**
	 * Adds an element to the end of the queue.
	 *
	 * @param data The data to be enqueued.
	 */
	public void enqueue(T data);

	/**
	 * Removes and returns the element at the front of the queue.
	 *
	 * @return The element removed from the front of the queue.
	 */
	public T dequeue();

	/**
	 * Returns the element at the front of the queue without removing it.
	 *
	 * @return The element at the front of the queue.
	 */
	public T peek();

	/**
	 * Prints the elements in the queue.
	 */
	public void print();
}
