import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class Main{

    public static void main(String[] args) {
        File file = new File("file.txt");
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("file.txt"));
            // Second arguement of out takes encoding type as a String
            // OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("file.txt"), "ASCII");
            InputStreamReader in = new InputStreamReader(new FileInputStream("file.txt"));
            
            System.out.println(out.getEncoding());

            out.write("CharacterStream\n");

            out.flush(); // forces buffer stream to written out
            // can write after executing flush method
            out.close(); // calls the flush method internally
            // cannot write any stream after executing close method

            int data = in.read();

            while (data != -1) {
                System.out.print((char)data);
                data = in.read();
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}