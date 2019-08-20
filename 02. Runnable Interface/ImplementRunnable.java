/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class ImplementRunnable implements Runnable{

    private int threadIndex;

    public ImplementRunnable(int index) {
        this.threadIndex = index;
    }
    @Override
    public void run() {
        int cilentNumber = 1;
        while (cilentNumber != 100) {
            System.out.println("Data from Server " + this.threadIndex + " sent successfully to cilent: " + cilentNumber);           
            cilentNumber++;  
        } 
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}