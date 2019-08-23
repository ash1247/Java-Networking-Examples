import java.io.*;
import java.net.Socket;
import java.util.regex.Pattern;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class Client {
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public static boolean validate(final String ip) {
        return PATTERN.matcher(ip).matches();
    }

    public static void main(String[] args) {
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(in);

            String ipAddress = "";
            String fileName = "";


            boolean isValid = false;

            while (!isValid) {
                System.out.print("Please enter a valid server IP address: ");
                ipAddress = reader.readLine();
                isValid = validate(ipAddress);
            }
            System.out.print("Please enter a file name: ");
            fileName = reader.readLine();

            Socket socket = new Socket(ipAddress, 9090);
            InputStream inputByte = socket.getInputStream();
            BufferedInputStream input = new BufferedInputStream(inputByte);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(fileName);
            int code = input.read();
            if (code == 1) {
                BufferedOutputStream outputFile = new BufferedOutputStream(
                        new FileOutputStream(fileName));
                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                while ((bytesRead = input.read(buffer)) != -1) {
                    System.out.print(".");
                    outputFile.write(buffer, 0, bytesRead);
                    outputFile.flush();
                }
                System.out.println();
                System.out.println("File: " + fileName + "was successfully downloaded");
            } else {
                System.out.println("File is not present in the system");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
