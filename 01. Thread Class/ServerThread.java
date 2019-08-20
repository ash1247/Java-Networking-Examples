/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class ServerThread extends Thread{

    public ServerThread(String threadName) {
        this.setName(threadName);        
    }

    @Override
    public void run() {
        int cilentNumber = 1;
        try {
            while (cilentNumber != 100) {
                System.out.println("Data from " + this.getName() + " sent successfully to cilent: " + cilentNumber);
                Thread.sleep(100);
                cilentNumber++;
            }  
        } catch (Exception e) {
            System.out.println(e.toString());
        } 
    }
}