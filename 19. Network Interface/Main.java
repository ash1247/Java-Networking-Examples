import java.io.*;
import java.net.*;
import java.util.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/
public class Main {
    public static void main(String[] args) {
        try {
            // InetAddress host = InetAddress.getByName("127.0.0.1");
            // getByInetAddress()
            // getByName()
            // getNetworkInterface()
            //NetworkInterface networkInterface = NetworkInterface.getByInetAddress(host);
            // NetworkInterface networkInterface = NetworkInterface.getByName("wlo1");
            
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
            
                if (networkInterface != null) {
                    System.out.println("NIC name: " + networkInterface.getName());
                    System.out.println("NIC display name: " + networkInterface.getDisplayName());
                    System.out.println("NIC hardware address: " + convertByteToString(networkInterface.getHardwareAddress()));
                    System.out.println("MTU: " + networkInterface.getMTU());
                    System.out.println("Index: " + networkInterface.getIndex());
                    NetworkInterface parentInterface = networkInterface.getParent();
                    if (parentInterface != null) {
                        System.out.println("Parent Interface: " + parentInterface.getDisplayName());    
                    } else {
                        System.out.println("No parent interface");
                    }
                    System.out.println("Is loopback?: " + networkInterface.isLoopback());
                    System.out.println("Is Up?: " + networkInterface.isUp());
                    System.out.println("Is Virtual?: " + networkInterface.isVirtual());
                    System.out.println("Support Multicast?: " + networkInterface.supportsMulticast());
                    List<InterfaceAddress> list = networkInterface.getInterfaceAddresses();
                    for (int i=0; i < list.size(); i++) {
                        System.out.println("IP Address: " + (list.get(i)).getAddress().getHostAddress());
                    }
                } else {
                    System.out.println("Interface not found.");
                }
                System.out.println("");
                System.out.println("_______________________________");
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static String convertByteToString(byte[] mac) {
        if (mac == null) 
            return null;
        
        StringBuilder sb = new StringBuilder(18);
        for (byte b : mac) {
            if (sb.length() > 0)
                sb.append(":");
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}