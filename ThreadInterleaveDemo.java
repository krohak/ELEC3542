public class ThreadInterleaveDemo {

	static class PrintOddThread extends Thread {

		// Print out odd numbers from 1 to 10
		public void run() {
			for (int i = 1; i <= 10; i = i + 2) {
				System.out.print(i + " ");

				// Idle for 10 ms after each print
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException ie) {
					System.exit(1);
				}
			}
		}

	}

	static class PrintEvenThread extends Thread {

		// Print out even numbers from 1 to 10
		public void run() {
			for (int i = 2; i <= 10; i = i + 2) {
				System.out.print(i + " ");

				// Idle for 10 ms after each print
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException ie) {
					System.exit(1);
				}
			}
		}

	}

	public static void main(String[] args) {
		PrintOddThread thread1 = new PrintOddThread();
		PrintEvenThread thread2 = new PrintEvenThread();
		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException ie) {
			System.exit(1);
		}

		System.out.println("end");
	}

}
