import java.util.*;
import java.net.*;
import java.io.*;

public class TokenRingMain {

    public static void main(String args[]) throws Exception {
        // Generate an Integer token
        Float token = new Float(0.0);

        // hostIp keeps all the IPs of other devices, modify according to your own network
        String hostIp[] = new String[3];
        hostIp[0] = "192.168.1.100";
        hostIp[1] = "192.168.1.101";
        hostIp[2] = "192.168.1.102";
        //hostIp[3] = "192.168.1.103";

        String nextHop = hostIp[0];
        Socket nextHopSocket = new Socket(nextHop, 4444);
        ObjectOutputStream out = new ObjectOutputStream(nextHopSocket.getOutputStream());

        int port = 4444;
        ServerSocket waitForTokenSocket = new ServerSocket(port);

        out.writeObject(hostIp);
        out.writeObject(token);

        Socket incomingSocket;
        while (true) {
            incomingSocket = waitForTokenSocket.accept();
            ObjectInputStream in = new ObjectInputStream(incomingSocket.getInputStream());

	    String[] ipListIn = (String[]) in.readObject();

            token = (Float) in.readObject();
            System.out.println("Token received " + token);

            break;
        }

        Thread.sleep(1000);
    }

}
