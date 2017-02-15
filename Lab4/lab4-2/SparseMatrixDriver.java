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

    public static void main(String[] args) {
        int numRow, numCol;

        numRow = numCol = 100;
        ListMatrix m = new ListMatrix(numRow, numCol);
        // ArrayMatrix m = new ArrayMatrix(numRow, numCol);

        m.addElt(2, 3, 4);
        m.addElt(1, 1, 5);
        m.addElt(2, 1, 7);
        m.addElt(3, 3, 2);
        m.addElt(2, 2, 3);

        // batchAddElt(10, m);

        m.printMatrix();

        /*
        int largestElt = m.findLargestElt();
        System.out.println("The largest element in the matrix is: " + largestElt);

        int sumOfCol = m.sumColumn(1);
        System.out.println("The sum of column 1 is: " + sumOfCol);
        */
    }

}
