// Base class for the two matrix implementations
public abstract class MyMatrix {

    protected int row, col; // Size of matrix: [row, col]

    public MyMatrix(int r, int c) {
        row = r;
        col = c;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // Add an element to the matrix
    // return false if the row/col specified is not valid
    // update the array element if it is already non-zero
    public abstract boolean addElt(int row, int col, int elt);

    // Print the non-zero elements in the matrix row-by-row
    public abstract void printMatrix();

    // Return the largest element in the matrix
    public abstract int findLargestElt();

    // Compute the sum of the elements in a given column
    public abstract int sumColumn(int col);
}
