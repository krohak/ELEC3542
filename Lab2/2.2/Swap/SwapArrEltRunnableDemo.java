public class SwapArrEltRunnableDemo {

	static class SwapArrEltRunnable implements Runnable{

private int[] arr;


public SwapArrEltRunnable(int[] list){
	arr= list;

}



// Swap the elements in arr


public void run() {


	int temp = arr[0];
	arr[0] = arr[1];
	arr[1] = temp;

					}

	}



	public static void main(String[] args) {

				int arr[] = {4,8};
				System.out.println("arr = " + arr[0] + ", " + arr[1]);


			Thread t = new Thread(new SwapArrEltRunnable(arr));

				t.start();


				try {Thread.sleep(100);}
				catch (InterruptedException e) {System.exit(1);}


				System.out.println("arr= " + arr[0] + ", " + arr[1]);



	}







}
