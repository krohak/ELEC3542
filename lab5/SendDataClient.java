import java.io.*;
import java.net.*;
import java.util.*;

public class SendDataClient {

    // Generate random report
    private static MyData genData() {
        long currentTime = System.currentTimeMillis();
        return new MyData((int) (Math.random() * 10), currentTime);
    }

    public static void main(String[] args) throws Exception {

	long start_time = System.currentTimeMillis();
	long time =0;

	while (true){
	
	if (time==1000){
	System.out.println(System.currentTimeMillis());
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] sendData;
        DatagramPacket outgoingPacket;



	
        MyData data = genData();

        ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
        ObjectOutputStream objOS = new ObjectOutputStream(byteOS);
        objOS.writeObject(data);
        sendData = byteOS.toByteArray();

        InetAddress ipAdress = InetAddress.getByName("localhost");
        outgoingPacket = new DatagramPacket(sendData, sendData.length, ipAdress, 3333);

        clientSocket.send(outgoingPacket);

        clientSocket.close();

	start_time = System.currentTimeMillis();

		}
	long stop_time = System.currentTimeMillis();
	time = stop_time - start_time;
	
	}


    }


}
