import java.io.*;
import java.net.*;
import java.util.*;

public class ReverseStringClient {

	public static void main(String[] args) throws Exception {
		long startTime, endTime, timeNeeded;
		//measure time before creating the socket
		startTime = System.currentTimeMillis();

		// Bind the socket to the server with the appropriate port
		Socket socket = new Socket("172.31.59.61", 1234);

		// Setup I/O streams
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		
		//measure time after setting up connection and calculate difference
		endTime = System.currentTimeMillis();
       		 timeNeeded = endTime - startTime;
		
		System.out.print("Enter the string you want to reverse: ");
		
		Scanner scan = new Scanner(System.in);
		String s;
		s = scan.nextLine();
		
		//measure time again
		startTime = System.currentTimeMillis();

		out.writeObject(s);
		out.flush();

		String result = (String) in.readObject();
		endTime = System.currentTimeMillis();
       		timeNeeded = timeNeeded+ ( endTime - startTime);	
		
		System.out.println("The result is: " + result);
		System.out.println("Time taken is: " + timeNeeded);

	}

}
