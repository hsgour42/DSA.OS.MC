package Scalar_DSA.backtracking.backtracking1;



//Problem Description
//Given an array of integers A, the array is square_ful if for every pair of adjacent elements,
// their sum is a perfect square.
//Find and return the number of permutations of A that are square_ful.
// Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

// A = [1, 17, 8]

import java.util.*;

//Output 2: 2
//Permutation are [1, 8, 17] and [17, 8, 1]
public class HomeworkQuestion1
{
    static Set<List<Integer>> listSet = new HashSet<>();
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 17 , 8);
        checkSquarefulPermutation(0 , list);
        System.out.println(listSet.size());
    }

    public static void  checkSquarefulPermutation(int index , List<Integer> list){
        if(index == list.size()){
            List<Integer> temp = new ArrayList<>(list);
            if(!listSet.contains(temp)){
                listSet.add(temp);
            }
            return;
        }

        for(int i = index ; i < list.size() ;i++) {
            swap(index, i, list);
            if (index == 0) {
                checkSquarefulPermutation(index + 1, list);
            } else if (checkSqaureful(list.get(i) + list.get(i - 1))) {
                checkSquarefulPermutation(index + 1, list);
            }
            swap(index , i , list);
        }
    }

    public static void swap(int i , int j , List<Integer> list){
        int temp = list.get(i);
        list.set(i , list.get(j));
        list.set(j , temp);
    }

    public static boolean checkSqaureful(int sqlVal){
        int val = (int) Math.sqrt(sqlVal);
        if(val * val == sqlVal){
            return true;
        }
        return false;
    }
}
