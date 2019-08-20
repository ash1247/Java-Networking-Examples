/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("output.txt"); 
            // append is enabled in the following line
            // FileOutputStream outputStream = new FileOutputStream("output.txt", true); 
            
            char c = '!';
            String s = "\nOuptutStream!";
            
            outputStream.write((char)c);
            outputStream.write(s.getBytes());
            outputStream.close();
 
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}