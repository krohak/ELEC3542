public class QuickSort {

	public static void sort(int[] list) {
		qsort(list, 0, list.length - 1);
	}

	// Swap list[i] with list[j]
	private static void swap(int[] list, int i, int j) {
		int temp;
		temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	// Recursive function to sort list[i] to list[j]
	private static void qsort(int[] list, int i, int j) {
		if (i >= j) return;

		if (i + 1 == j) {
			if (list[i] > list[j]) swap(list, i, j);
			return;
		}

		// Find the pivot position
		int pos = findPivot(list, i, j);

		if (pos == i) {
			qsort(list, i + 1, j);
			return;
		} else if (pos == j) {
			qsort(list, i, j - 1);
			return;
		} else { // Sort the two sublists divided by the pivot
			qsort(list, i, pos - 1);
			qsort(list, pos + 1, j);
		}
	}

	// list[i] is the pivot
	// Re-arrange the elements from list[i] to list[j] s.t.
	// the elements smaller than the pivot are on the left
	// while the elements larger than the pivot are on the right
	// pivot is in its right position
	private static int findPivot(int[] list, int i, int j) {
		int pivot = list[i];

		int left = i + 1, right = j;
		while (left < right) {
			while (left <= j && list[left] <= pivot) left++;
			while (right > i && list[right] > pivot) right--;

			if (left < right) {
				swap(list, left, right);
				left++;
				right--;
			}
		}

		int k = i + 1;
		while (k <= j && list[k] <= pivot) {
			list[k - 1] = list[k];
			k++;
		}
		if (k == j) {
			list[j] = pivot;
			return j;
		} else {
			list[k - 1] = pivot;
			return k-1;
		}
	}

}
