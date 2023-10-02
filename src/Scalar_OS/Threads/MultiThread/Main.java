package Scalar_OS.Threads.MultiThread;

//Implement a program that print 1 to 100 each from separate thread
public class Main {
    public static void main(String[] args) {
        System.out.println("Calling from Main method where thread name is : " + Thread.currentThread().getName() );
        for(int i = 1 ; i <= 100 ; i++){
            NumberPrint np = new NumberPrint(i);
            Thread t = new Thread(np);
            t.start();
        }
    }
}
