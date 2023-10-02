package Scalar_OS.Threads.UsingExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);
        for(int i = 1 ; i <= 100 ; i++){
            NumberPrinter np = new NumberPrinter(i);
            executor.execute(np);
        }
    }
}
