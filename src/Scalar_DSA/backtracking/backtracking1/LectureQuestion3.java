package Scalar_DSA.backtracking.backtracking1;

//# Generate all permutation of array with distinct element (shuffling)
// Eg : 4   7   9
//      4   9   7
//      7   4   9
//      7   9   4
//      9   4   7
//      9   7   4

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectureQuestion3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4 , 7 ,9);
        List<List<Integer>> result = new ArrayList<>();
        allPermutation(list , 0 , result);
        for (List<Integer> values : result){
            System.out.println(values);
        }
    }

    public static void allPermutation(List<Integer> list ,int index , List<List<Integer>> result ){
        if(index == list.size()){
            List<Integer> copyList = new ArrayList<>(list);
            result.add(copyList);
            return;
        }

        for(int i = index ; i < list.size() ; i++){
            swap(list , index , i );
            allPermutation(list , index + 1 , result);
            swap(list , index , i);     //to back to original position we need swap back
        }
        return;
    }

    public static void swap(List<Integer> list ,int  i ,int  j){
        int temp =  list.get(i);
        list.set( i , list.get(j));
        list.set( j , temp);
    }
}

//TC : O(n!)
//SC : O(n)
