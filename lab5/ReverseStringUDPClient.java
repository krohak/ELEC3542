import java.io.*;
import java.net.*;
import java.util.*;

public class ReverseStringUDPClient {

    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] receiveData = new byte[1024];
        byte[] sendData;
        DatagramPacket sendPacket, receivePacket;
	long startTime, endTime, timeNeeded;
        // Ask for user input
        System.out.print("Enter the string you want to reverse: ");
        Scanner scan = new Scanner(System.in);
        String s;
        s = scan.nextLine();

        sendData = s.getBytes();

        // Get the IP address as an InetAddress object
        InetAddress addr = InetAddress.getByName("172.31.59.61");

	startTime = System.currentTimeMillis();
        // Create the outgoing datagram
        sendPacket = new DatagramPacket(sendData, sendData.length, addr, 1234);
        // Send out the packet using the socket
        clientSocket.send(sendPacket);

        // Accept an incoming packet
        receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String result = new String(receivePacket.getData());

	endTime = System.currentTimeMillis();
	timeNeeded =  endTime - startTime;


        System.out.println("The result is: " + result);
	System.out.println("Time taken is: " + timeNeeded);

        clientSocket.close();
    }

}
