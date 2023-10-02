package Scalar_DSA.backtracking.backtracking2;

//Solve Sudoku
//Rules for valid state
// 1: All number are unique in row
// 2: All number are unique in column
// 3: All number are unique in inner 3 * 3 matrix

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Hint : total column in sudoku is 81
// find row number = number / 9;
// find col number = number % 9;
// find inner box  = cube row => row / 3
//                 = cube col => col / 3
public class LectureQuestion3 {
    public static void main(String[] args) {
        int sudoku[][] = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }

        };
        solveSudoku(0 , sudoku);

    }

    public static boolean solveSudoku(int index , int[][] sudoku){
        //We reached at end
        if(index  >= 81){
            for(int[] list : sudoku ){
                System.out.println(Arrays.toString(list));
            }
            return true;
        }
        int row = index / 9;
        int col = index % 9;

        if(sudoku[row][col] != 0){
           return solveSudoku(index + 1 , sudoku);
        }

        //find all possible value
        for(int option = 1 ;  option <= 9 ; option++){
            //checking all rule
            if( followRule(row , col ,option , sudoku)) {
                //setting option
                sudoku[row][col] = option;
                //solve all new possibility next
                if (solveSudoku(index + 1, sudoku)) {
                    return true;
                } else {
                    //backtracking
                    sudoku[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static boolean followRule(int row , int col , int option , int[][] sudoku){
                boolean valid = true;
                valid  &= checkAllRow(row , option , sudoku);
                valid  &= checkAllColumn(col, option , sudoku);
                valid  &= checkInnerCube(row , col , option , sudoku);
                return valid;
    }

    public static boolean checkAllRow(int row , int option , int[][] sudoku){
        for(int col = 0 ; col < 9 ; col++){
            if(sudoku[row][col] == option){
                return false;
            }
        }
        return true;
    }

    public static boolean checkAllColumn(int col, int option , int[][] sudoku){
        for(int row = 0 ; row < 9 ; row++){
            if(sudoku[row][col] == option){
                return false;
            }
        }
        return true;
    }

    public static boolean checkInnerCube(int row , int col, int option, int[][] sudoku){
        //multiplying 3 help us find the starting position
        int cubeRow = (row / 3) * 3;
        int cubeCol = (col / 3) * 3;
        for(int i = cubeRow ; i < cubeRow + 3 ; i++){
            for(int j = cubeCol ; j < cubeCol + 3 ; j++){
                if(sudoku[i][j] == option){
                    return false;
                }
            }
        }
        return true;
    }
}




