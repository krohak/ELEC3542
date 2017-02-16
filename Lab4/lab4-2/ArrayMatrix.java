public class ArrayMatrix extends MyMatrix {

    int[][] elt;

    public ArrayMatrix(int row, int col) {
        super(row, col);
        elt = new int[row][col];
    }

    public boolean addElt(int row, int col, int element) {

        elt[row][col] = element;

        return true;
    }

    public void printMatrix() {

      System.out.println("Row: " + row + "; Col: " + col);

      for (int i=0; i<row; i++){

          for (int j=0; j<col; j++){

          if(elt[i][j] != 0){

              System.out.print("[" + i + ", " + j + "," + elt[i][j] + "] ");

          }



        }



      }
      System.out.println();

    }

    public int findLargestElt() {
        int max = 0;


        for (int i=0; i<row; i++){

          for (int j=0; j<col; j++){

            if(elt[i][j]>max){

                max = elt[i][j];

            }



          }



        }


System.out.println();

        return max;
    }

    public int sumColumn(int col) {
        int sum = 0;


        for (int i=0; i<row; i++){


            if(elt[i][col] != 0){

                sum = sum + elt[i][col];

            }

        }


//System.out.println();

        return sum;
    }

}
