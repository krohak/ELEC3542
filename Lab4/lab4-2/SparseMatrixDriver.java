public class SparseMatrixDriver {

    // Adding num elements in the matrix
    public static void batchAddElt(int num, MyMatrix m) {

        int row = m.getRow();
        int col = m.getCol();

        for (int i = 0; i < num; i++) {
            int r = (int) (Math.random() * row);
            int c = (int) (Math.random() * col);
            int elt = (int) (Math.random() * 99) + 1;

            m.addElt(r, c, elt);
        }
    }

    public static void main(String[] args)  {
        int numRow, numCol;

        long startTime, endTime, timeNeeded;

        if (args.length < 1) {
            System.out.println("You have to input the size of array");
            System.exit(1);
        }

        int size = 0;
        int batch = 0;
        try {
            size = Integer.parseInt(args[0]);
            batch = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("You have to input valid numbers.");
            System.exit(1);
        }


        numRow = numCol = size;
        ListMatrix m = new ListMatrix(numRow, numCol);
        //ArrayMatrix m = new ArrayMatrix(numRow, numCol);

         /*
        m.addElt(2, 3, 4);
        m.addElt(1, 1, 5);
        m.addElt(2, 1, 7);
        m.addElt(3, 3, 2);
        m.addElt(2, 2, 3);
        */
         batchAddElt(batch, m);
         System.out.println("The memory used after creating the " + numRow +"x" + numCol + " input array is: " + MeasureMemory.memoryUsed());

        startTime = System.currentTimeMillis();

        m.printMatrix();

        endTime = System.currentTimeMillis();
        timeNeeded = endTime - startTime;
        System.out.print("The time needed to print " + numRow +"x" + numCol + " Array is " + timeNeeded + " ms.");

      //  /*
        //int largestElt = m.findLargestElt();
        //System.out.println("The largest element in the matrix is: " + largestElt);

        startTime = System.currentTimeMillis();
        int sumOfCol = m.sumColumn(1);
        endTime = System.currentTimeMillis();
        timeNeeded = endTime - startTime;
        System.out.println("The sum of column 1 is: " + sumOfCol);
        System.out.println("The time needed to print the sum of column 1 is " + timeNeeded + " ms.");
    //  */
    }

}
