import java.io.*;
import java.net.*;
import java.util.*;

public class ReverseStringUDPClient {

    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] receiveData = new byte[1024];
        byte[] sendData;
        DatagramPacket sendPacket, receivePacket;

        // Ask for user input
        System.out.print("Enter the string you want to reverse: ");
        Scanner scan = new Scanner(System.in);
        String s;
        s = scan.nextLine();

        sendData = s.getBytes();

        // Get the IP address as an InetAddress object
        InetAddress addr = InetAddress.getByName("localhost");

        // Create the outgoing datagram
        sendPacket = new DatagramPacket(sendData, sendData.length, addr, 1234);
        // Send out the packet using the socket
        clientSocket.send(sendPacket);

        // Accept an incoming packet
        receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String result = new String(receivePacket.getData());

        System.out.println("The result is: " + result);

        clientSocket.close();
    }

}
