import java.io.*;
import java.net.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/
public class Main {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
            InetAddress address2 = InetAddress.getByName("google.com");
            System.out.println(address2.getHostAddress());
            System.out.println(address2.getHostName());
            Socket socket = new Socket(address, 9090);
            System.out.println(socket);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}