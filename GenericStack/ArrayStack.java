/**
 * @garrettspillman1
 *                   A generic implementation of a stack using an array.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class ArrayStack<T> implements StackInterface<T> {
	private T[] stack;
	private int head; // Index of the first null element
	public static final int DEFAULT_SIZE = 100;

	/**
	 * Constructs an ArrayStack with the default size.
	 */
	public ArrayStack() {
		init(DEFAULT_SIZE);
	}

	/**
	 * Constructs an ArrayStack with a specified size.
	 *
	 * @param size The initial size of the stack.
	 */
	public ArrayStack(int size) {
		init(size);
	}

	private void init(int size) {
		head = 0;
		if (size >= 1)
			stack = (T[]) (new Object[size]);
		else
			stack = (T[]) (new Object[DEFAULT_SIZE]);
	}

	/**
	 * Adds an element to the top of the stack.
	 *
	 * @param data The data to be pushed onto the stack.
	 */
	public void push(T data) {
		if (head >= stack.length)
			return;
		stack[head] = data;
		head++;
	}

	/**
	 * Removes and returns the element from the top of the stack.
	 *
	 * @return The element removed from the top of the stack.
	 */
	public T pop() {
		if (head == 0)
			return null;
		T ret = stack[head - 1];
		head--;
		return ret;
	}

	/**
	 * Returns the element from the top of the stack without removing it.
	 *
	 * @return The element from the top of the stack.
	 */
	public T peek() {
		if (head == 0)
			return null;
		return stack[head - 1];
	}

	/**
	 * Prints the elements in the stack.
	 */
	public void print() {
		for (int i = head - 1; i >= 0; i--)
			System.out.println(stack[i]);
	}
}
