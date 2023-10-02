package Scalar_OS.Synchronization.Keyword;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count(0); //Initialized Value

        ExecutorService  es = Executors.newCachedThreadPool(); // Thread service generate

        //get both task
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        //run both task
        es.execute(adder);
        es.execute(subtractor);

        es.shutdown(); // mean => send signal that someone is waiting // this will not terminate the thread or task they just give the signal for termination
        es.awaitTermination(100, TimeUnit.MINUTES); // if under this time not complete terminate forcefully terminate after 100 Minutes

        System.out.println(count.value);
    }
}
