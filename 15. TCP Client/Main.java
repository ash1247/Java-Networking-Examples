import java.io.*;
import java.net.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/
public class Main {
    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            System.out.println("Server IP Address: " + serverAddress.getHostAddress());
            Socket socket = new Socket(serverAddress, 9090);
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(input.readLine());
            out.println("hello server!");
            
            input.close();
            out.close();
            socket.close();

        } catch (UnknownHostException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}