package Heaps;

/**
 * @garrettspillman1
 *                   A generic implementation of a Max Heap data structure.
 *
 * @param <T> The type of elements stored in the Max Heap, must extend
 *            Comparable.
 */
public class MaxHeap<T extends Comparable<T>> {
	private T[] heap;
	private int size; // First Null Element
	public static final int DEF_SIZE = 128;

	/**
	 * Constructs a MaxHeap with the default size.
	 */
	public MaxHeap() {
		init(DEF_SIZE);
	}

	/**
	 * Constructs a MaxHeap with a specified size.
	 *
	 * @param aSize The initial size of the Max Heap.
	 */
	public MaxHeap(int aSize) {
		init(aSize);
	}

	private void init(int aSize) {
		if (aSize <= 0) {
			init(DEF_SIZE);
			return;
		}
		heap = (T[]) (new Comparable[aSize]);
		size = 0;
	}

	/**
	 * Adds an element to the Max Heap.
	 *
	 * @param aData The data to be added to the Max Heap.
	 */
	public void add(T aData) {
		if (heap[heap.length - 1] != null)
			return;
		heap[size] = aData;
		bubbleUp();
		size++;
	}

	private void bubbleUp() {
		// Find larger of the two children
		int index = size;
		while (index > 0 && heap[(index - 1) / 2].compareTo(heap[index]) < 0) {
			// Swap
			T temp = heap[(index - 1) / 2];
			heap[(index - 1) / 2] = heap[index];
			heap[index] = temp;
			index = (index - 1) / 2;
		}
	}

	/**
	 * Removes and returns the maximum element from the Max Heap.
	 *
	 * @return The maximum element removed from the Max Heap.
	 */
	public T remove() {
		if (size <= 0)
			return null;
		T ret = heap[0];
		heap[0] = heap[size - 1];
		heap[size - 1] = null;
		size--;
		bubbleDown();
		return ret;
	}

	private void bubbleDown() {
		int index = 0; // Start from root
		while (index * 2 + 1 < size) {
			// Find larger of the two children
			int bigIndex = index * 2 + 1;
			if (index * 2 + 2 < size && heap[index * 2 + 1].compareTo(heap[index * 2 + 2]) < 0)
				bigIndex = index * 2 + 2;
			if (heap[index].compareTo(heap[bigIndex]) < 0) {
				// Swap
				T temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			} else
				break;
			index = bigIndex;
		}
	}

	/**
	 * Returns the maximum element from the Max Heap without removing it.
	 *
	 * @return The maximum element from the Max Heap.
	 */
	public T peek() {
		return heap[0];
	}

	/**
	 * Prints the elements in the Max Heap in breadth order.
	 */
	public void print() {
		for (int i = 0; i < size; i++)
			System.out.println(heap[i]);
	}
}