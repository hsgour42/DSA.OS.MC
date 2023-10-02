package Scalar_OS.Threads.UsingExecutor.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrToSort = List.of(
                10,2,8,11,4,3,9,1
        );

        ExecutorService es = Executors.newCachedThreadPool();
        Sorter st = new Sorter(arrToSort);
        Future<List<Integer>> futureSortedArr = es.submit(st);
        List<Integer> sortedArr = futureSortedArr.get();
        for(Integer value : sortedArr){
            System.out.println(value);
        }


    }
}
