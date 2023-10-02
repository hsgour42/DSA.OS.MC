package Scalar_DSA.backtracking.backtracking1;


//# Unique Paths III
//Given a matrix of integers A of size N x M . There are 4 types of squares in it:

//1. 1 represents the starting square.  There is exactly one starting square.
//2. 2 represents the ending square.  There is exactly one ending square.
//3. 0 represents empty squares we can walk over.
//4. -1 represents obstacles that we cannot walk over.
//Find and return the number of 4-directional walks from the starting square to the ending square,
//that walk over every non-obstacle square exactly once.
// {Walk every obstacle}
//Input 1:

//A = [   [1, 0, 0, 0]
//        [0, 0, 0, 0]
//        [0, 0, 2, -1]   ]

//Output 1: 2

//We have the following two paths:
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)


public class AssignmentQuestion3 {
    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 2, -1 }
        };

        int availableBlocks = 0;
        int row = -1;
        int col = -1;

        for(int i = 0 ; i < maze.length ; i++ ){
            for (int j = 0 ; j < maze[0].length ; j++){
                if(maze[i][j] == 0){
                    availableBlocks += 1;
                    //setting starting position
                }

                if(maze[i][j] == 1){
                        row = i;
                        col = j;
                }
            }
        }

        int totalPath = findAllAvailablePath(row , col , 0 , availableBlocks , maze );
        System.out.println(totalPath);
    }

    public static int findAllAvailablePath(
            int row ,
            int col,
            int usedBlocks,
            int availableBlocks,
            int[][] maze
    ){
        //base case
        if(row < 0 || col < 0  || row >= maze.length || col >= maze[0].length){
            return 0;
        }

        //reached with all block used
         if(usedBlocks == availableBlocks && maze[row][col] == 2){
             return 1;
         }

         //reached with not all block used
         if(usedBlocks != availableBlocks && maze[row][col] == 2){
             return 0;
         }

         //if we cannot walk or already visited
        if(maze[row][col] == -1 || maze[row][col] == 3){
            return  0;
        }

        if(maze[row][col] == 0){
            usedBlocks = usedBlocks + 1;
        }
        maze[row][col] = 3;
        int ans = findAllAvailablePath(row , col + 1 , usedBlocks , availableBlocks , maze)
                + findAllAvailablePath(row , col - 1 , usedBlocks  , availableBlocks , maze)
                + findAllAvailablePath(row +1  , col , usedBlocks  , availableBlocks , maze)
                + findAllAvailablePath( row - 1 , col , usedBlocks , availableBlocks , maze);
        maze[row][col] = 0;
        return  ans;
    }
}
