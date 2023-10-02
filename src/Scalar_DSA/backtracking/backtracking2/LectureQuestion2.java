package Scalar_DSA.backtracking.backtracking2;

import java.util.*;

//# N Queen problem
//Rules for valid state
// 1: Not in same row
// 2: Not in same column
// 3: Not in same diagonal
public class LectureQuestion2 {

    private static Set<Integer> topQueen = new HashSet<>();
    private static Set<Integer> topLeftDiagonal = new HashSet<>();
    private static Set<Integer> topRightDiagonal = new HashSet<>();
    private static List<List<String>> finalBoard = new ArrayList<>();

    public static void main(String[] args) {
        int boardSize = 4;
        placeNQueen(0 , boardSize , new ArrayList<>());
        for(List list : finalBoard){
            System.out.println(list);
        }
    }

    public static void placeNQueen(int row , int boardSize ,  List<Integer> queenPositions) {
        if(row == boardSize){
            //there is a multiple way to place queen in board we need a list for each variant
            List<String> totalWays = new ArrayList<>();
            for(int position : queenPositions){
                List<Character> boardCol = new ArrayList<>(Arrays.asList(new Character[boardSize]));
                boardCol.size();
                Collections.fill(boardCol , '.');
                boardCol.set(position , 'Q');
                totalWays.add(boardCol.toString());
            }
            finalBoard.add(totalWays);
            return;
        }

        //check all valid state
        for(int col = 0 ; col < boardSize ;col++){
            if(topQueen.contains(col) ||
                    (topLeftDiagonal.contains(row - col) ||
                            (topRightDiagonal.contains(row + col))
                    )
            ){
                continue;
            }

            //if we not found queen place the queen
            queenPositions.add(col);
            topQueen.add(col);
            topLeftDiagonal.add(row - col);
            topRightDiagonal.add(row + col);


            //move with new queen
            placeNQueen(row + 1 , boardSize ,queenPositions);

            //not found good place then backtrack
            queenPositions.remove(queenPositions.size() - 1);
            topQueen.remove(col);
            topLeftDiagonal.remove(row - col);
            topRightDiagonal.remove(row + col);


        }
    }


}
