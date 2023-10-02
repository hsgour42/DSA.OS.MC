package Scalar_DSA.Comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityqueuecomparator {
    public static void main(String[] args) {
        int[] A = new int[]{1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297 };
        int B = 42;
        int[] result = solve(A , B);



    }


    static class Pair{
        double fracVal;
        int firstVal;
        int secondVal;
        public Pair(double fracVal , int firstVal , int secondVal){
            this.fracVal = fracVal;
            this.firstVal = firstVal;
            this.secondVal = secondVal;
        }
    }
    public static int[] solve(int[] A, int B) {
        int len = A.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new FractionComparator());

        for (int j : A) {
            minHeap.add(new Pair(0, j, j));
        }
        while (!minHeap.isEmpty()){
            Pair p = minHeap.poll();
            System.out.println("Value : " + p.firstVal);
        }

        Pair result = new Pair(0 , 0 , 0);

        return new int[]{result.firstVal , result.secondVal};
    }

    static class FractionComparator implements Comparator<Pair> {
        public int compare(Pair p1 , Pair p2){
            double fracVal1 = p1.firstVal;
            double fracVal2 = p2.firstVal;
            if(fracVal1  < fracVal2){
                return -1;
            }else{
                return 1;
            }
        }
    }
}


