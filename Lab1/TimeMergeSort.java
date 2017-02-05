import java.io.*;
import java.util.*;

public class TimeMergeSort {

	public static void main(String[] args) throws IOException {
		long startTime, endTime, timeNeeded;

		if (args.length < 1) {
			System.out.println("You have to input the size of array to be sorted.");
			System.exit(1);
		}

		int size = 0;
		try {
			size = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("You have to input a valid number.");
			System.exit(1);
		}
		
		for (int j=40000000; j<=size; j+=1000000){

		int input[] = new int[j];

		for (int i = 0; i < j; i++) {
			input[i] = (int) (Math.random() * 99999);
		}

		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(input);
		endTime = System.currentTimeMillis();
		timeNeeded = endTime - startTime;

		System.out.println("The time needed to sort " + j + " numbers is " + timeNeeded + " ms.");
	}
	}

}
