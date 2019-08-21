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
            while (!stop) {
                System.out.println("Waiting for clients.....");
                Socket socket = server.accept();
                System.out.println("Cilent is connected.");
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
            }
            server.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}