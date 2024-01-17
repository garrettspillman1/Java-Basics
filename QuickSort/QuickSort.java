package QuickSort;

public class QuickSort {

	public static void main(String[] args) { // Tester
		int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		quickSort(array);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int[] array, int start, int end) {
		if (start >= end)
			return;
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

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
