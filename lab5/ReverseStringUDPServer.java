import java.io.*;
import java.net.*;

public class ReverseStringUDPServer {

    // Returns a String that is the reverse of the parameter s
    public static String reverse(String s) {
        String result = "";
        int length = s.length();

        for (int i = length - 1; i >= 0; i--) {
            result = result + s.charAt(i);
        }

        return result;
    }

    public static void main(String args[]) throws Exception {
        // Create and bind the socket with a certain port
        DatagramSocket serverSocket = new DatagramSocket(1234);

        // Declare buffers and packets variables
        byte[] sendData, receiveData;
        DatagramPacket sendPacket, receivePacket;

        while (true) {
            // Accept an incoming packet
            receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // Read the data carried in the incoming packet
            String s = new String(receivePacket.getData());
            String result = reverse(s);

            // Prepare reply to the client and send out the reply
            sendData = result.getBytes();
            InetAddress ipAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
            serverSocket.send(sendPacket);
        }
    }

}
