public class SortRunnable implements Runnable{


private int[] arr;

public SortRunnable(int[] list){
	arr= list;

}


public void run(){

MergeSort.mergeSort(arr);


}







}
