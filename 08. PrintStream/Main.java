import java.io.PrintStream;
import java.io.File;

/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class Main{

    public static void main(String[] args) {
        File file = new File("file.txt");
        try {
            PrintStream out = new PrintStream(new File("output.txt"));
            // if file already exists
            // PrintStream out = new PrintStream("output.txt");
            
            String spell = "Avada Kedavra";
            out.println("The spell is " + spell);
            out.append("You shall die if this hits you!\n");
            out.close(); 

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}