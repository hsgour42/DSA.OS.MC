package Lambdas;

public class DemoForRunnable {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread thread  =  new Thread(r);
        thread.start();

        Thread thread1 = new Thread( () -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread1.start();

    }
}
