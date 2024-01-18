package MergeSort;

/**
 * @garrettspillman1
 *                   Implementation of the Merge Sort algorithm for sorting an
 *                   array of integers.
 */
public class MergeSort {

	/**
	 * Main method to test the MergeSort algorithm.
	 *
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		// Tester
		int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		mergeSort(array);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}

	/**
	 * Sorts an array of integers using the Merge Sort algorithm.
	 *
	 * @param array The array to be sorted.
	 */
	public static void mergeSort(int[] array) {
		int size = array.length;
		if (size < 2)
			return;
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];
		for (int i = 0; i < mid; i++)
			leftArray[i] = array[i];
		for (int i = mid; i < size; i++)
			rightArray[i - mid] = array[i];
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
	}

	/**
	 * Merges two sorted arrays into a single sorted array.
	 *
	 * @param leftArray  The left sorted array.
	 * @param rightArray The right sorted array.
	 * @param array      The merged array.
	 */
	public static void merge(int[] leftArray, int[] rightArray, int[] array) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		int i = 0; // leftArray index
		int j = 0; // rightArray index
		int k = 0; // Merged Array (array) index
		while (i < leftSize && j < rightSize) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
				k++;
			} else {
				array[k] = rightArray[j];
				j++;
				k++;
			}
		}
		while (i < leftSize) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}
}