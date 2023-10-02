package Scalar_OS.Threads.SingleThread;

public class HelloWorldPrinter implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World from HelloWorldPrinter Class" + " Thread name " + Thread.currentThread().getName());
    }
}
