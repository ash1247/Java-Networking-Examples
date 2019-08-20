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

        if (file.exists()) {
           System.out.println("File already exists! " + file.getName());            
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println("File was created!");
                    System.out.println("File path: " + file.getAbsolutePath());
                } else {
                    System.out.println("Cannot create file.");
                }
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file.getName()));
            DataInputStream in = new DataInputStream(new FileInputStream(file.getName()));
        
            out.writeInt(72);
            out.writeDouble(12413.234);
            out.writeFloat(1213.23F);

            System.out.println("integer value: " + in.readInt());
            System.out.println("double value: " + in.readDouble());
            System.out.println("float value: " + in.readFloat());
            out.close();
            in.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}