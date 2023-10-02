package Scalar_DSA.backtracking.backtracking2;

//Rat in a maze try all possible path
//0 means non - block
//1 means blocked
//2 means visited
public class LectureQuestion1 {
    public static void main(String[] args) {
        int maze[][] = {
                { 0, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 }
        };
        int n = maze.length;
        int m = maze[0].length;
        boolean ans = findPathInMaze(0,0 , n , m, maze);
        System.out.println(ans);
    }

    public static boolean findPathInMaze(int i,int j,int n ,int m,int[][] maze){
        if(i == n - 1 && j == m - 1){
            return true;
        }
        if(i < 0 || j < 0 ||  i >= n || j >= n){
            return false;
        }
        if(maze[i][j] == 1 || maze[i][j] == 2){
            return false;
        }

        maze[i][j] = 2;

        boolean ans = findPathInMaze(i , j + 1 , n , m , maze)  //right
                || findPathInMaze(i , j - 1 , n , m , maze)     //left
                || findPathInMaze(i + 1 , j , n , m , maze)     //down
                || findPathInMaze(i - 1 , j , n , m , maze);    //up

        maze[i][j] = 0;
        return ans;
    }
}

//TC = O(n * m)
//SC = O(n * m)
