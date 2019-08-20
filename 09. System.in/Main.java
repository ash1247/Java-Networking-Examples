import java.io.InputStreamReader;

import java.io.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/
public class Main{
    public static void main(String[] args) {
        System.out.print("Please enter a port number: ");

        InputStreamReader in = new InputStreamReader(System.in);

        BufferedReader reader = new BufferedReader(in);

        boolean isValid = false;

        int port = 0;

        while (!isValid) {
            try {
                port = Integer.parseInt(reader.readLine());
                System.out.println("Port is accepted");
                isValid = true;
            } catch (Exception e) {
                System.out.println("Please insert a number.");
                System.out.print("Please enter the port number: ");
            }
        }

        System.out.print("Please enter the server IP address: ");

        String ipaddress = "";

        try {
            ipaddress = reader.readLine();
        } catch (Exception e) {
            System.err.println("Cannot read the ip address! " + e.toString());
        }

        System.out.println("");
        System.out.println("_____________________________");
        System.out.println("");
        System.out.println("Trying to connect to IP: " + ipaddress + " on port " + port + "....");
    }
}