import java.io.*;
import java.net.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/
public class Main {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        String targetIp = "";
        int fromPort = 0;
        int toPort = 0;

        System.out.print("Enter the target IP address: ");

        try {
            targetIp = reader.readLine();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Please enter the first port: ");
                String portString = reader.readLine();
                fromPort = Integer.parseInt(portString);
                if (fromPort >=0 && fromPort <= 65536) {
                    isValid = true;
                } else {
                    System.out.println("Invalid port: Port range is 0 - 65536");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number" + e.toString());
            } catch (Exception e) {
                System.out.println("Cannot read the port number " + e.toString());
            }
        }

        isValid = false;

        while (!isValid) {
            try {
                System.out.print("Please enter the last port: ");
                String portString = reader.readLine();
                toPort = Integer.parseInt(portString);
                if (toPort >=0 && toPort <= 65536) {
                    if (toPort >= fromPort) {
                        isValid = true;
                    }
                } else {
                    System.out.println("Invalid port: Port range is 0 - 65536");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number" + e.toString());
            } catch (Exception e) {
                System.out.println("Cannot read the port number " + e.toString());
            }
        }

        int port = fromPort;
        while (port >= fromPort && port <= toPort) {
            try {
                Socket socket = new Socket(targetIp, port);
                System.out.println("Port " + port + " is in listening state.");
                socket.close();
            } catch (UnknownHostException e) {
                System.out.println(port + " " + e.toString()); 
            } catch (IOException e) {
                System.out.println(port + " " + e.toString()); 
            } catch (Exception e) {
                System.out.println(port + " " + e.toString()); 
            }
            port++;
        }
    }
}