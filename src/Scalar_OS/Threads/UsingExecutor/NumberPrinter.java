package Scalar_OS.Threads.UsingExecutor;

public class NumberPrinter implements Runnable{
    int number;
    public NumberPrinter(int number){
        this.number = number;
    }
    @Override
    public void run() {
        System.out.println("Current number : "  + number + " Thread Name :  " + Thread.currentThread().getName() );
    }
}
