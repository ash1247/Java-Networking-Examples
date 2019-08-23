import java.io.*;
import java.net.*;
import java.util.*;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/
public class Main {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9090);
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            while(true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData,
                                                    receiveData.length);
                socket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                System.out.println("Received: " + sentence);
                String stringData = "Hello Client";
                sendData = stringData.getBytes();

                InetAddress clientIPAddress = receivePacket.getAddress();
                
                
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData, 
                                                sendData.length, clientIPAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}