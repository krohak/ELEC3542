import java.io.*;
import java.net.*;
import java.util.*;

public class ReverseStringClient {

	public static void main(String[] args) throws Exception {
		// Bind the socket to the server with the appropriate port
		Socket socket = new Socket("localhost", 3333);

		// Setup I/O streams
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		System.out.print("Enter the string you want to reverse: ");
		Scanner scan = new Scanner(System.in);
		String s;
		s = scan.nextLine();

		out.writeObject(s);
		out.flush();

		String result = (String) in.readObject();

		System.out.println("The result is: " + result);
	}

}
