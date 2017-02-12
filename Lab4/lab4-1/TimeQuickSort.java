import java.io.*;
import java.util.*;

public class TimeQuickSort {

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

        int input[] = new int[size];

        for (int i = 0; i < size; i++) {
            input[i] = (int) (Math.random() * 99999);
        }

        System.out.println("The memory used after creating the input array is: " + MeasureMemory.memoryUsed());

        startTime = System.currentTimeMillis();
        QuickSort.sort(input);
        endTime = System.currentTimeMillis();
        timeNeeded = endTime - startTime;

        /*
        if (!verify(input))
            System.out.println("The sorting result is wrong.");
        */

        System.out.println("The time needed to sort " + size + " numbers is " + timeNeeded + " ms.");
    }

    private static boolean verify(int[] list) {
        for (int i = 0; i < list.length - 1; i++)
            if (list[i] > list[i + 1]) return false;

        return true;
    }

}
