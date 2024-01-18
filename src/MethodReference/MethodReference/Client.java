package MethodReference.MethodReference;

import java.util.Arrays;
import java.util.List;

//Use for code re-use
public class Client {
    public static void main(String[] args) {
        //Non-static method call with class object
        DoTaskFunctionalInterface printNumberNonStatic = new TaskWorking()::printNumber;
        printNumberNonStatic.doTask();

        DoTaskFunctionalInterface  printTask = TaskWorking::printingTask;
        printTask.doTask();

        DoTaskFunctionalInterface printPower = TaskWorking::generatePower;
        printPower.doTask();

        Runnable runnable = TaskWorking::printThreadNumber;
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Runnable runnable2 = TaskWorking::printThreadNumberPower;
        Thread thread2 = new Thread(runnable2);
        thread2.start();


        //with parameter
        DoTaskWithParameterFunctionalInterface task = TaskWorking::printingTask;
        task.print("Testing method reference with parameter");


        List<Integer> list = Arrays.asList(10,30,40,30,50,60,39,05);
        list.forEach(System.out::println);
    }
}
