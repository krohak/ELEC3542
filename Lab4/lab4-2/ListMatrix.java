public class ListMatrix extends MyMatrix {

    // Node representing the row index node
    private class IndexNode {

        private int index;
        private IndexNode next;
        private EltNode eltList;

        IndexNode(int i, IndexNode iNode, EltNode eNode) {
            index = i;
            next = iNode;
            eltList = eNode;
        }

    }

    // Node representing an element in the array
    private class EltNode {

        private int row;
        private int col, elt; // The row, col, and the value of this element
        private EltNode next;

        EltNode(int r, int c, int i) {
            row = r;
            elt = i;
            col = c;
            next = null;
        }

    }

    private IndexNode rowList;

    public ListMatrix(int row, int col) {
        super(row, col);
        rowList = null;
    }

    public void printMatrix() {
        System.out.println("Row: " + row + "; Col: " + col);
        IndexNode iNode = rowList;
        while (iNode != null) {
            System.out.print(iNode.index + " : ");

            EltNode eNode = iNode.eltList;
            while (eNode != null) {
                System.out.print("[" + eNode.col + ", " + eNode.elt + "] --> ");
                eNode = eNode.next;
            }

            iNode = iNode.next;
            System.out.println();
        }

    }

    // Return the node in the list with index just smaller
    // or the same as the parameter index
    public IndexNode findPosInList(IndexNode list, int index) {
        if (list == null) return null;
        if (list.index > index) return null;

        IndexNode currNode = list;
        while (currNode.next != null) {
            // System.out.println("currNode.next.index = " + currNode.next.index);
            if (currNode.next.index <= index)
                currNode = currNode.next;
            else
                break;
        }

        return currNode;
    }

    // Row and col indices start from 0
    public boolean addElt(int row, int col, int elt) {

        if (this.row <= row || this.col <= col || row < 0 || col < 0) return false;

        EltNode newENode = new EltNode(row, col, elt);

        if (rowList == null) { // it is the first element added
            rowList = new IndexNode(row, null, newENode);
            return true;
        }

        // Update rowList
        // if the current first row index is larger than the new row index
        if (row < rowList.index) {
            IndexNode newRNode = new IndexNode(row, rowList, newENode);
            rowList = newRNode;
            return true;
        }

        // Find the new IndexNode position
        IndexNode prevNode = findPosInList(rowList, row);
        // System.out.println("prevNode.index = " + prevNode.index + " row = " + row);
        if (prevNode.index < row) { // insert a new IndexNode
            IndexNode newRNode = new IndexNode(row, prevNode.next, newENode);
            prevNode.next = newRNode;
            return true;
        }

        // The IndexNode of the same index exists, insert elt in the eltList
        if (prevNode.eltList.col > col) { // the element is the first in the list
            // System.out.println("prevNode.eltList.col > col");
            newENode.next = prevNode.eltList;
            prevNode.eltList = newENode;
            return true;
        }

        // Find the position to insert the element node
        EltNode eltNode = prevNode.eltList;
        while (eltNode.next != null) {
            if (eltNode.next.col < col)
                eltNode = eltNode.next;
            else
                break;
        }

        // System.out.println("eltNode.col = " + eltNode.col);
        if (eltNode.col == col) { // Element already exists
            // System.out.println("here");
            eltNode.elt = elt;
            return true;
        }

        // Add new element node
        newENode.next = eltNode.next;
        eltNode.next = newENode;

        return true;
    }

    public int findLargestElt() {
        if (rowList == null) return 0;

        IndexNode rowNode = rowList;
        EltNode eltNode = rowList.eltList;

        int max = 0;
        while (rowNode != null) {
            eltNode = rowNode.eltList;
            while (eltNode != null) {
                if (eltNode.elt > max)
                    max = eltNode.elt;

                eltNode = eltNode.next;
            }

            rowNode = rowNode.next;
        }

        return max;
    }

    public int sumColumn(int col) {
        if (rowList == null) return 0;

        IndexNode rowNode = rowList;
        EltNode eltNode = rowList.eltList;
        int sum = 0;
        while (rowNode != null) {
            eltNode = rowNode.eltList;
            while (eltNode != null) {
                if (eltNode.col == col)
                    sum += eltNode.elt;

                eltNode = eltNode.next;
            }

            rowNode = rowNode.next;
        }

        return sum;
    }

}
