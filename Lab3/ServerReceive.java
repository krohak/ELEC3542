import java.io.*;
import java.net.*;

public class ServerReceive {


	public static void main(String[] args) throws Exception {
		// Create server socket listening on port
		int port = 1234;
		long startTime, endTime, timeNeeded;
		ServerSocket serverSocket = new ServerSocket(port);

		// Declare client socket
		Socket clientSocket;

		while (true) { // Provide service continuously
			clientSocket = serverSocket.accept();

			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

			int[] s = null;
		 	s = (int[]) in.readObject();

			startTime = System.currentTimeMillis();
			MergeSort.mergeSort(s);
			endTime = System.currentTimeMillis();
			timeNeeded = endTime - startTime;

			System.out.println("The time needed to sort is "  + timeNeeded + " ms on the Server");

			out.writeObject(s);
			out.flush();

			out.close();
			in.close();
			clientSocket.close();
		}
	}

}
