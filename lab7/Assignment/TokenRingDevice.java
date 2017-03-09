import java.util.*;
import java.net.*;
import java.io.*;

public class TokenRingDevice {

    public static void main(String[] args) throws Exception {
        // Create server socket listening on port
        int port = 4444;
        ServerSocket waitForTokenSocket = new ServerSocket(port);

        // Declare client socket
        Socket incomingSocket;

        // Declare variable for the token
        Float token;

        while (true) {
            incomingSocket = waitForTokenSocket.accept();
            ObjectInputStream in = new ObjectInputStream(incomingSocket.getInputStream());

            String[] ipListIn = (String[]) in.readObject();
            token = (Float) in.readObject();

            String nextHop;
            if (ipListIn.length > 1) { // The next hop is another device
                nextHop = ipListIn[1];
                System.out.println("I received the previous average temperature " + token + ", and will pass it to " + ipListIn[1]);
            } else { // this is the last device in the ring
                nextHop = "192.168.1.1";
                System.out.println("I received the previous average temperature " + token + ", and will pass it to router");
            }

            // MODIFY THE FILE PATH IF NECESSARY
            //Runtime.getRuntime().exec("python3 print_temperature.py");
            Process p = Runtime.getRuntime().exec("python3 print_temperature.py");

            Thread.sleep(2000);

            BufferedReader bufIn =new BufferedReader(new InputStreamReader(p.getInputStream()));
            String pythonOutput = bufIn.readLine();

            System.out.println("Measured temperature " + pythonOutput);

            if (token==0.0){

              token =  Float.parseFloat(pythonOutput);
            }

            else{
              //calculate the Average
              int number=1;
              for (number=1; number<3-ipListIn.length; number++ );

              token = (number*token + Float.parseFloat(pythonOutput))/(number+1);

            }

            System.out.println("New avergae temperature " + token);

            // Prepare the list of devices for sending to the next device
            String[] ipListOut = new String[ipListIn.length - 1];
            for (int i = 0; i < ipListOut.length; i++) {
                ipListOut[i] = ipListIn[i + 1];
            }

            Socket nextHopSocket = new Socket(nextHop, 4444);
            ObjectOutputStream out = new ObjectOutputStream(nextHopSocket.getOutputStream());
            out.writeObject(ipListOut);
            out.writeObject(token);
            out.flush();

            out.close();
            in.close();
            nextHopSocket.close();

            break;
        }
    }

}
