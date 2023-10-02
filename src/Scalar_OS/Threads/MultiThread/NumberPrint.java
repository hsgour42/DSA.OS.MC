package Scalar_OS.Threads.MultiThread;

public class NumberPrint implements Runnable{
    int number;
    public NumberPrint(int number){
        this.number = number;
    }
    @Override
    public void run() {

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



        if(number == 60){
            System.out.println("We are at 60");
        }
        System.out.println("Current Number : " +  number  + " Thread Name : " + Thread.currentThread().getName());
    }
}
