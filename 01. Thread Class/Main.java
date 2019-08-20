/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

// difference between Thread.start() and Thread.run() methods.
// 1. start() creates a new thread and execute run method, but
//    executes on the current thread.
// 2. You cannot call start() method twice from a single thread object,
//      an IllegalStateException error will occur, but you can call 
//      run twice.

public class Main{
    public static void main(String[] args) {
        ServerThread thread = new ServerThread("Server 1");
        ServerThread thread2 = new ServerThread("Server 2");
        thread2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(thread2.getName() + " P: " + thread2.getPriority());
        thread.start();
        thread2.start();
        System.out.println("S");
    }
}