import java.io.*;
import java.net.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/
public class Main {
    public static void main(String[] args) {
        String hostAddress = "google.com";
        try {
            InetAddress host = InetAddress.getByName(hostAddress);
            System.out.println(host.isReachable(1000));
            Process p = Runtime.getRuntime().exec("ping " + hostAddress);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String commandOutput = "";
            boolean isReachable = true;

            while ((commandOutput = inputStream.readLine()) != null) {
                System.out.println(commandOutput);
                if (commandOutput.contains("Destination host unreachable")) {
                    isReachable = false;
                    break;
                }
            }
            if (isReachable) {
                System.out.println("host is reachable");
            } else {
                System.out.println("host is unreachable");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}