import java.io.*;
import java.net.Socket;
import java.util.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class ClientThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private File file;
    private boolean isStop;
    final static String CRLF = "\r\n";

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.isStop = false;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            String line;
            String httpReader = "";
            String htmlFile = "";

            while (true) {
                line = in.readLine();
                if (line.equals(CRLF) || line.equals("")) 
                    break;
                
                httpReader = httpReader + line + "\n";

                if (line.contains("GET")) {
                    int beginIndex = line.indexOf("/");
                    int endIndex = line.indexOf(" HTTP");
                    htmlFile = line.substring(beginIndex+1, endIndex);
                }
            }

            System.out.println(httpReader);

            closeConnection();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void processRequest(String htmlFile) throws Exception {
        File file = new File(htmlFile);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            out.print("HTTP/1.0 200 OK" + CRLF);
            Date date = new Date();
            out.print("Date: " + date.toString() + CRLF);
            out.print("Server: Java tiny web server." + CRLF);
            out.print("Content Type: text/html" + CRLF);

            String line = "";
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        } else {
            out.print("HTTP/1.0 404 Not Found" + CRLF);
            Date date = new Date();
            out.print("Date: " + date.toString() + CRLF);
            out.print("Server: Java tiny web server.");
            out.print("Connection Closed." + CRLF);
            out.print("Content Type: text/html" + CRLF);

            out.println("<html><head>");
            out.println("<title>404 Not Found</title>");
            out.println("</head><body>");
            out.println("<h1>404 NOT FOUND</h1>");
            out.println("</body></html>");
        }
    }

    public void closeConnection() {
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
