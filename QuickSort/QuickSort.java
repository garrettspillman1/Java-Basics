package QuickSort;

/**
 * @garrettspillman1
 *                   Implementation of the Quick Sort algorithm for sorting an
 *                   array of integers.
 */
public class QuickSort {

	/**
	 * Main method to test the QuickSort algorithm.
	 *
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		// Tester
		int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		quickSort(array);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}

	/**
	 * Sorts an array of integers using the Quick Sort algorithm.
	 *
	 * @param array The array to be sorted.
	 */
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * Recursive method to perform Quick Sort on a specific range of the array.
	 *
	 * @param array The array to be sorted.
	 * @param start The starting index of the range to be sorted.
	 * @param end   The ending index of the range to be sorted.
	 */
	public static void quickSort(int[] array, int start, int end) {
		if (start >= end)
			return;
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	/**
	 * Chooses a pivot, partitions the array, and returns the index of the pivot.
	 *
	 * @param array The array to be partitioned.
	 * @param start The starting index of the partition.
	 * @param end   The ending index of the partition.
	 * @return The index of the pivot element after partitioning.
	 */
	public static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start;
		for (int j = start; j <= end; j++) {
			if (array[j] < pivot) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
			}
		}
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;
		return i;
	}
}