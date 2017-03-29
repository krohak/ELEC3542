import java.io.*;
import java.net.*;
import java.io.Serializable;

import javax.crypto.SecretKey;
import javax.crypto.SealedObject;

public class ReverseStringServer {

	// Returns a String that is the reverse of the parameter s
	public static String reverse(String s) {
		String result = "";
		int length = s.length();

		for (int i = length - 1; i >= 0; i--) {
			result = result + s.charAt(i);
		}

		return result;
	}

	public static void main(String[] args) throws Exception {

		AESEncryption bob = new AESEncryption();
		SecretKey bobKey = bob.getSecretEncryptionKey("alice&bob");

		// Create server socket listening on port
		int port = 3333;
		ServerSocket serverSocket = new ServerSocket(port);

		// Declare client socket
		Socket clientSocket;

		while (true) { // Provide service continuously
			clientSocket = serverSocket.accept();

			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

			String s = (String) in.readObject();


			String decryptedText = (String) bob.decrypt(s, bobKey);


			String result = reverse(decryptedText);

			SealedObject cipherObject = bob.encrypt(result, bobKey);

			out.writeObject(String(cipherObject));
			out.flush();

			out.close();
			in.close();
			clientSocket.close();
		}
	}

}
