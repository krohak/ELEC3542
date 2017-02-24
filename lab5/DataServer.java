import java.io.*;
import java.net.*;

public class DataServer {

    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(3333);

        DatagramPacket incomingPacket;
        MyData data;
        byte[] incomingData;
	float total=0;
	int counter=0;

        while (true) {
            incomingData = new byte[1024];
            incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            serverSocket.receive(incomingPacket);

            byte[] dataInByte = incomingPacket.getData();
            ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(dataInByte));

            data = (MyData) is.readObject();
  	    total=total+data.getValue();
            counter++;
	    float average = total/counter;
	    System.out.println(data);
	    System.out.println("The average of the reports is " + average);
        }
    }

}
