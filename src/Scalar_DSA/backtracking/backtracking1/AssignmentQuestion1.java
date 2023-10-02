package Scalar_DSA.backtracking.backtracking1;

//# Given a set of distinct integers A, return all possible subsets.
//# Note :
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.                         //hashSet work for this
// Also, the subsets should be sorted in ascending ( lexicographic ) order.     // sort work for this
// The list is not necessarily sorted.

import javax.management.StandardEmitterMBean;
import java.util.*;

//@Example
//A = [1, 2, 3]
// [
// []
// [1]
// [1, 2]
// [1, 2, 3]
// [1, 3]
// [2]
// [2, 3]
// [3]
// ]
public class AssignmentQuestion1 {
    static List<List<Integer>> result = new ArrayList<>();
    static Set<List<Integer>> setList = new HashSet<>();
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, -20, -11, -8, -4, 2, -12, 14, 1, -18);
        Collections.sort(list);

        generateSubSet(0 ,new ArrayList<>() ,list);

        Collections.sort(result ,  (l1 , l2) -> resultNonDescendingOrder(l1 , l2) );

        for(List<Integer> integers : result){
            System.out.println(integers.toString());
        }
    }

    public static void generateSubSet(int index,List<Integer> generator ,List<Integer> list){
        if(index == list.size()){
            if(!setList.contains(generator)){
                setList.add(generator);
                List<Integer> temp = new ArrayList<>(generator);
                result.add(temp);
            }
            return;
        }

        //Take it
        generator.add(list.get(index));
        generateSubSet(index + 1 , generator , list);
        generator.remove(generator.size() - 1);

        //Not take it
        generateSubSet(index + 1 , generator , list);
    }


    public static int resultNonDescendingOrder(List<Integer> l1 , List<Integer> l2){
         for(int i = 0 ; i < l1.size() &&  i < l2.size() ; i++){

             if(l1.get(i) < l2.get(i)){
                 return -1;
             }
             if(l1.get(i) > l2.get(i)){
                 return  1;
             }
         }
         if(l1.size() < l2.size()){
             return  -1;
         }else{
             return 1;
         }

    }


}
