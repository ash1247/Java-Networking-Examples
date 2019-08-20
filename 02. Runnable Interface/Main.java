/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

public class Main {
    public static void main(String[] args) {
        ImplementRunnable implementRunnable = new ImplementRunnable(1);
        Thread thread = new Thread(implementRunnable);
        thread.start();

        ImplementRunnable implementRunnable2 = new ImplementRunnable(2);
        Thread thread2 = new Thread(implementRunnable2, "Server 2");
        thread2.start();
        
        ImplementRunnable implementRunnable3 = new ImplementRunnable(3);
        implementRunnable3.start();
    }
}