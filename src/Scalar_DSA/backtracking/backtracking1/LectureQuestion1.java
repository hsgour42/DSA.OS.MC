package Scalar_DSA.backtracking.backtracking1;

import java.util.*;
import java.util.stream.StreamSupport;

//print all n digit number which can be formed using {1,2}
//{111,112,121...}
public class LectureQuestion1 {
    public static void main(String[] args) {
        int n = 3;
        solve(n);
    }

    public static void solve(int n){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(0 , n , list,result);
        for(List<Integer> newList : result) {
            System.out.println(newList);
        }
    }

    public static void backTracking(int index , int n ,List<Integer> list, List<List<Integer>> result){
        if(index == n){
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }

        //take 1 and go to next till we not reach at peek
        list.add(index,1);
        backTracking(index + 1 , n , list, result);
        list.remove(index);     //if we reach peek as 111 , remove last item


        //insert 2 and go to next till we not reach at peek
        list.add(index,2);
        backTracking(index + 1 , n , list, result);
        list.remove(index);

    }


}
