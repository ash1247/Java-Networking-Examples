import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/
public class Main {
    public static void main(String[] args) {
        boolean stop = false;
        try {
            ServerSocket server = new ServerSocket(9090);
            System.out.println("Waiting for clients.....");
            while (!stop) {
                Socket socket = server.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                // second arguement is for auto flash
                out.println("Hello client");
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientInput = input.readLine();
                System.out.println(clientInput);
                input.close();
                out.close();
                socket.close();
            }
            server.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}