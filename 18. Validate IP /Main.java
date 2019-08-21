import java.io.*;
import java.net.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/
public class Main {
    public static void main(String[] args) {
        InetAddressValidator validator = new InetAddressValidator();
        String ipAdress = "192.168.0.10";
        boolean isValid = validator.isValid(ipAdress);

        if (isValid) {
            System.out.println(ipAdress + " is valid.");
        } else {
            System.out.println(ipAdress + " is not valid.");
        }
    }

    public boolean validateIpAddress(String ipAdress) {
        String[] numbers = ipAdress.split("\\.");
        if (numbers.length != 4) { 
            return false;
        }
        for (String str: numbers) {
            int i = Integer.parseInt(str);
            if ((i<0) || (i>255)) {
                return false;
            }
        }

        return true;
    }
}