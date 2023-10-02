package Scalar_DSA.Comparator;

import java.util.*;

public class mamapriorityqueuecomparator2 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-99,-10,-5,-5,-4,-55,-33};
        int n = maximumProduct(nums);
        System.out.println(n);
    }

    static class SortComparator implements Comparator<Integer>{
       @Override
        public int compare(Integer val1 ,Integer val2){
            return val2.compareTo(val1) ;
        }
    }

    public static int maximumProduct(int[] nums) {
        int len = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new SortComparator());
        List<Integer> arr = new ArrayList<>();
        int product = 1;
        for (int num : nums) {
            maxHeap.add(num);
            arr.add(num);
        }
        arr.sort(new SortComparator());
        for(int i = 0 ; i < 3 ; i++){
            product *= maxHeap.poll();
        }
        return product;
    }
}
