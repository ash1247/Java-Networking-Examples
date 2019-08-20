import java.net.ServerSocket;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class Main {
    public static void main(String[] args) {
        int port = 1;
        while (port <= 65335) {
            try {
                ServerSocket server = new ServerSocket(port);
            } catch (Exception e) {
                System.out.println(e + "Port " + port + " is open");
            }
            port++;
        }
    }
}