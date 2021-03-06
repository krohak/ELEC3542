public class ThreadForLoopAssignment {

	public static int[] x = {1,2,3,4,5};


	static class CopyThread extends Thread {

		public void run() {
			for (int i = 2; i < x.length; i = i + 2)
				x[i] = x[i-2]+2*i-1;
		}

	}

	public static void main(String[] args) {
		x[0] = 0;
		x[1] = 1;

		CopyThread thread = new CopyThread();
		thread.start();


		for (int i = 3; i < x.length; i = i + 2)
			x[i] = x[i-2]+2*i-1;


		System.out.print("The x[] is: ");
		for (int i = 0; i < x.length; i++)
			System.out.print(x[i] + " ");
		System.out.println();


	}

}
