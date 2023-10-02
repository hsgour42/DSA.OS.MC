package Scalar_DSA.backtracking.backtracking1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Find the count of all subset which sum is equal to 5
public class LectureQuestion2 {
    public static int count = 0;

    public static void main(String[] args) {
        int sum = 5;
        List<Integer> input  = Arrays.asList( -10, 15 , 9 );
        countAllSubset(0 , 0 , sum , input);
        System.out.println(count);
    }

    //think about include or not include
    public static void countAllSubset(int currentSum , int i ,int sum , List<Integer> input){
        if(i == input.size()){
            if(currentSum == sum){
                count++;
            }
            return;
        }
        //include
        countAllSubset(currentSum + input.get(i)  , i + 1 , sum, input);

        //not include
        countAllSubset(currentSum , i + 1 , sum , input);
    }
}

//every level increasing by 2^0 , 2^1 , ...
//TC : O(2n)
//SC : O(n)
