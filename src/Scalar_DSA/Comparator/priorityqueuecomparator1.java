package Scalar_DSA.Comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityqueuecomparator1 {
    static class Pair{
        int distance;
        int index;
        public Pair(int distance , int index){
            this.distance = distance;
            this.index = index;
        }
    }

    static class DistanceComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1 , Pair p2){
            int d1 = p1.distance;
            int d2 = p2.distance;

            if(d1 < d2){
                return -1;
            }else if(d2 < d1){
                return 1;
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                {48, 18},
                {46, 34},
                {47, 30},
                {19, 9},
                {1, 39},
                {95, 77},
                {95, 106},
                {78, 75},
                {92, 108},
                {89, 83},
                {80, 76}
        };

        int B = 5;
        int[][] result = solve(A , B);



    }
    public static int[][] solve(int[][] A, int B) {
        int len = A.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new DistanceComparator());

        for(int i = 0 ; i < len ; i++){
            int firstVal = A[i][0];
            int secondVal = A[i][1];
            int diff = firstVal + secondVal;
            Pair pair = new Pair(diff, i);
            minHeap.add(pair);
        }

        for(Pair p : minHeap){
            System.out.println(p.distance);
        }

        int[][] result = new int[B][2];

//        for(int i = 0 ; i < B ; i++){
//            Pair pair = minHeap.poll();
//            assert pair != null;
//            int index = pair.index;
//            result[i][0] =  A[index][0];
//            result[i][1] =  A[index][1];
//        }
        return result;
    }
}
