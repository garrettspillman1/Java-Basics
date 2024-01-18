/**
 * @garrettspillman1
 *                   A generic interface for a stack.
 *
 * @param <T> The type of elements stored in the stack.
 */
public interface StackInterface<T> {

	/**
	 * Adds an element to the top of the stack.
	 *
	 * @param data The data to be pushed onto the stack.
	 */
	public void push(T data);

	/**
	 * Removes and returns the element from the top of the stack.
	 *
	 * @return The element removed from the top of the stack.
	 */
	public T pop();

	/**
	 * Returns the element from the top of the stack without removing it.
	 *
	 * @return The element from the top of the stack.
	 */
	public T peek();

	/**
	 * Prints the elements in the stack.
	 */
	public void print();
}
