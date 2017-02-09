import java.io.*;
import java.net.*;

public class RemoteMergeSort {

	public static int[] mergeSort(int[] list) throws IOException {
		Socket clientSocket;
		ObjectOutputStream out = null;
		ObjectInputStream in = null;

		try {
			clientSocket = new Socket("localhost", 1234);

			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host!");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection.");
			System.exit(1);
		}

		out.writeObject(list);
		out.flush();

		int[] sortedList = null;

		try {
			sortedList = (int[]) in.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return sortedList;
	}

}
