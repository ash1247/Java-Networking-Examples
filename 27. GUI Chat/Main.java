/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class Main 
{
    public static void main(String [] args)
    {
        MainFrame mainFrame = new MainFrame(); //create the MainFrame object
        Thread thread  = new Thread(mainFrame); //run in a new thread
        thread.start(); //start the thread
    }
}
