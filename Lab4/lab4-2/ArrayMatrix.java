public class ArrayMatrix extends MyMatrix {

    int[][] elt;

    public ArrayMatrix(int row, int col) {
        super(row, col);
        elt = new int[row][col];
    }

    public boolean addElt(int row, int col, int element) {
        return true;
    }

    public void printMatrix() {

    }

    public int findLargestElt() {
        int max = 0;

        return max;
    }

    public int sumColumn(int col) {
        int sum = 0;

        return sum;
    }

}
