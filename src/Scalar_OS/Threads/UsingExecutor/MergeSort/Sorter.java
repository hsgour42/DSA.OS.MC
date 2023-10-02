package Scalar_OS.Threads.UsingExecutor.MergeSort;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Sorter implements Callable<List<Integer>> {
    private  List<Integer> unsortedArr ;

    public Sorter(List<Integer> unsortedArr){
        this.unsortedArr = unsortedArr;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(unsortedArr.size() <= 1){
            return  unsortedArr;
        }

        int mid  = unsortedArr.size() / 2;
        List<Integer> leftArrayToSort = new ArrayList<>();
        List<Integer> rightArrayToSort = new ArrayList<>();

        for(int i = 0 ; i < mid ; i++){
            leftArrayToSort.add(unsortedArr.get(i));
        }

        for(int i = mid ; i < unsortedArr.size() ; i++){
            rightArrayToSort.add(unsortedArr.get(i));
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        Sorter leftSorter = new Sorter(leftArrayToSort);
        Sorter rightSorter = new Sorter(rightArrayToSort);

        Future<List<Integer>> futureLeftSortedArr = executor.submit(leftSorter);
        Future<List<Integer>> futureRightSortedArr = executor.submit(rightSorter);



        List<Integer> leftSortedArr = futureLeftSortedArr.get();
        List<Integer> rightSortedArr = futureRightSortedArr.get();
        List<Integer> sortedArr = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < leftSortedArr.size() && j < rightSortedArr.size()){
            if(leftSortedArr.get(i) <= rightSortedArr.get(j) ){
                sortedArr.add(leftSortedArr.get(i));
                i++;
            }else{
                sortedArr.add(rightSortedArr.get(j));
                j++;
            }
        }

        while(i < leftSortedArr.size()){
            sortedArr.add(leftSortedArr.get(i));
            i++;
        }

        while( j < rightSortedArr.size()){
            sortedArr.add(rightSortedArr.get(j));
            j++;
        }

        return sortedArr;
    }
}
