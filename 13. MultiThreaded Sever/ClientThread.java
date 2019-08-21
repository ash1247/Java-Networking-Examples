import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class ClientThread extends Thread{

    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // second arguement is for auto flash
            out.println("Hello client");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientInput = input.readLine();
            System.out.println(clientInput);
            input.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}