package Scalar_DSA.backtracking.backtracking1;


//# All Unique Permutations

//Given an array A of size N denoting collection of numbers that might contain duplicates,
//return all possible unique permutations.

//A = [1, 1, 2]
//Output 1:
//[ [1,1,2]
//  [1,2,1]
//  [2,1,1] ]

import java.util.*;

public class AssignmentQuestion4 {
    private static Set<List<Integer>> setList = new HashSet<>();
    private static List<List<Integer>> allPermutation = new ArrayList<>();
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,2);
        generateUniquePermutation(0 , list);

        for(List<Integer> list1 : allPermutation){
            System.out.println(list1.toString());
        }
    }

    public static void generateUniquePermutation(int index , List<Integer> list){
        if(index == list.size()){
            List<Integer> temp = new ArrayList<>(list);
            if(!setList.contains(temp)){
                setList.add(temp);
                allPermutation.add(temp);
            }
            return;
        }

        for(int i = index ; i < list.size() ; i++){
            swap(index , i , list);
            generateUniquePermutation(index + 1 , list);
            swap(index , i , list);
        }
    }

    public static void swap(int i  , int j , List<Integer> list){
        int temp = list.get(i);
        list.set(i ,  list.get(j));
        list.set(j , temp);
    }
}
