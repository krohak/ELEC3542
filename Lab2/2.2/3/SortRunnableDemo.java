public class SortRunnableDemo {


static class SortRunnable implements Runnable{


private int[] arr;

public SortRunnable(int[] list){
	arr= list;

}


public void run(){

MergeSort.mergeSort(arr);


}







}



public static void main(String[] args){

  int arr[] = {4,8,1,2,7,659,2,1,4};

  for (int i = 0; i<arr.length; i++) {
  System.out.println(arr[i] + ", "); }


  Thread t = new Thread(new SortRunnable(arr));

  t.start();

  try {Thread.sleep(100);}
  catch (InterruptedException e) {System.exit(1);}


  for (int i = 0; i<arr.length; i++) {
  System.out.println(arr[i] + ", "); }




}






}
