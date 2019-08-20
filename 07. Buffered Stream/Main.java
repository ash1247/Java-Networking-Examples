import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class Main{

    public static void main(String[] args) {
        File file = new File("file.txt");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
            BufferedReader in = new BufferedReader(new FileReader("file.txt"));
            // BufferedReader in = new BufferedReader(new FileReader("file.txt"), (int)BUFFER_SIZE);
            
            String line = null;

            while((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }
            in.close();
            out.close(); 

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}