import java.net.*;

public class PrintHostname {

    public static void main(String[] args) throws Exception {
        System.out.println(Inet4Address.getLocalHost().getHostName());
    }

}
