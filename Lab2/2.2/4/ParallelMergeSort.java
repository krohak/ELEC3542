public class ParallelMergeSort {

	public static void mergeSort(int[] list) {
		if (list.length <= 1) return;

		// Split the array in half
		int[] first = new int[list.length / 2];
		int[] second = new int[list.length - first.length];
		for (int i = 0; i < list.length / 2; i++)
			first[i] = list[i];
		for (int i = 0; i < list.length - first.length; i++)
			second[i] = list[list.length / 2 + i];

		// Sort each half, one by another thread, one by the main thread
		Thread t1 = new Thread(new MergeSort(first));
		t1.start();
		MergeSort.mergeSort(second);

		try {

			t1.join();


		} catch (Exception ie) {
			System.exit(1);
		}




		// Merge the halves together, overwriting the original array
		int iFirst = 0, iSecond = 0, i = 0;
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] <= second[iSecond]) {
				list[i++] = first[iFirst++];
			} else {
				list[i++] = second[iSecond++];
			}
		}

		while (iFirst < first.length)
			list[i++] = first[iFirst++];
		while (iSecond < second.length)
			list[i++] = second[iSecond++];
	}

}
