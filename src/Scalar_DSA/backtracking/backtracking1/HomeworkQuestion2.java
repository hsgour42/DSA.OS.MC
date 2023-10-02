package Scalar_DSA.backtracking.backtracking1;


//# Letter Phone

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Given a digit string A, return all possible letter combinations that the number could represent.
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
//Input 1: A = "23"
//Output 1: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
public class HomeworkQuestion2 {
    static HashMap<Integer , String> keyPadMap = new HashMap<>();
    static List<String> allCombination = new ArrayList<>();

    public static void main(String[] args) {
        //Keypad
        keyPadMap.put(0 , "0");
        keyPadMap.put(1 , "1");
        keyPadMap.put(2 , "abc");
        keyPadMap.put(3 , "def");
        keyPadMap.put(4 , "ghi");
        keyPadMap.put(5 , "jkl");
        keyPadMap.put(6 , "mno");
        keyPadMap.put(7 , "pqrs");
        keyPadMap.put(8 , "tuv");
        keyPadMap.put(9 , "wxyz");

        String pressedNumber = "23";

        generateAllCombination(0 , new ArrayList<>() , pressedNumber);
        for(String str : allCombination){
            System.out.println(str);
        }
    }



    public static void generateAllCombination(int index ,List<Character> characterList , String pressedNumber){


    }
}

