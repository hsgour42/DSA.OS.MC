package Scalar_OS.Threads.SingleThread;

//Print hello world from separate thread
public class Main {
    public static void main(String[] args) {
        HelloWorldPrinter hwp = new HelloWorldPrinter();
        System.out.print("Inside Main Class ");
        System.out.println(" Thread Name " +  Thread.currentThread().getName());
        Thread t = new Thread(hwp);
        t.start();
        System.out.println(t.getName());

        Thread t1 = new Thread(hwp);
        t1.start();
        System.out.println(t1.getName());


        System.out.print("Inside Main Class again ");
        System.out.println(" Thread Name " +  Thread.currentThread().getName());




    }
}
