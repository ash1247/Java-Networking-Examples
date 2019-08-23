import java.io.*;
import java.net.*;
import java.util.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*   You will need a local smtp server to run this program properly
*/


public class Main { 
    private static Socket smtpSocket;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        try {
            smtpSocket = new Socket("localhost", 25);
            in = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
            out = new PrintWriter(smtpSocket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            System.err.println("Unknown Hostname.");
        } catch (IOException e) {
            System.err.println("I/O connection failure.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        if(smtpSocket != null && out != null && in != null) {
            try {
                String responseLine;
                responseReader("250");

                out.println("Hello " + InetAddress.getLocalHost().getHostAddress());
                System.out.println("Hello " + InetAddress.getLocalHost().getHostAddress());
                responseReader("250");

                out.println("Send from test@test.com");
                responseReader("250");

                out.println("Receipant sagor.ashikul@gmail.com");
                responseReader("250");

                out.println("DATA");
                responseReader("354");


                out.println("From: test@test.com");
                out.println("To: sagor.ashikul@gmail.com");
                out.println("Subject: Test EMAIL");
                out.println();
                out.println("This is a test email");
                out.println();
                
                responseReader("250");

                out.println("QUIT");
                responseReader("221");

                System.out.println("Email Successfully sent!");

                in.close();
                out.close();
                smtpSocket.close();
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }

        void responseReader(String responseCode) {
            while ((responseLine = in.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.indexOf(responseCode) != -1) 
                        break;
            }
        }
    }
}