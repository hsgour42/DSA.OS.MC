package Scalar_DSA.backtracking.backtracking1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Permutations
// Given an integer array A of size N denoting collection of numbers , return all possible permutations.

//NOTE:
//No two entries in the permutation sequence should be the same.                //use hashset
//For the purpose of this problem, assume that all the numbers in the collection are unique.
//Return the answer in any order

//Example:
//A = [1, 2, 3]
//Output :
// [
//  [1, 2, 3]
//  [1, 3, 2]
//  [2, 1, 3]
//  [2, 3, 1]
//  [3, 1, 2]
//  [3, 2, 1]
//  ]
public class AssignmentQuestion2 {
    public static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        generatePermutation( 0 ,list);

        Collections.sort(result , (l1 , l2) -> {
            for(int i = 0 ; i < l1.size() && i < l2.size() ; i++){
                if(l1.get(i) < l2.get(i)){
                    return -1;
                }else{
                    return 1;
                }
            }
            return 1;
        });

        for (List<Integer>  list1 : result){
            System.out.println(list1.toString());
        }
    }

    public static void generatePermutation(int index ,List<Integer> list){
        //Base Case
        if(index == list.size()){
            List<Integer> tempList = new ArrayList<>(list);
            result.add(tempList);
            return;
        }

        for(int i = index ; i < list.size() ; i++){
            //do swap
            swap(index , i , list);
            generatePermutation(index + 1 , list);
            //backtrack
            swap(index , i ,list);
        }
    }
    public static void swap(int i , int j , List<Integer> list){
        int temp = list.get(i);
        list.set(i , list.get(j));
        list.set(j , temp);
    }

}
