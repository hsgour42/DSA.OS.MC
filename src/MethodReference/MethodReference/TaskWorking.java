package MethodReference.MethodReference;

public class TaskWorking {
    public static void printingTask(){System.out.println("Working on task");}

    public static void printingTask(String str){System.out.println(str);}

    public static void generatePower(){
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println(i * i);
        }
    }

    public void printNumber(){
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println(i);
        }
    }

    public static void printThreadNumber()  {
        for(int i = 20 ; i <= 30 ; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printThreadNumberPower()  {
        for(int i = 30 ; i <= 40 ; i++){
            System.out.println(i*i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
