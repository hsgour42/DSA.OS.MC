package Scalar_DSA.Comparator;

import java.sql.Struct;
import java.util.*;

public class SortHashMap {
    public static void main(String[] args){
       //Create hash map
        Map<Integer,String> hm = new HashMap<>();
        hm.put(1,"xyz");
        hm.put(5,"abc");
        hm.put(7,"cde");
        hm.put(3,"bcd");
        hm.put(6,"pqr");
        hm.put(4,"efg");
        hm.put(9,"yxz");

        hm.forEach((key , val) -> {
            System.out.println(key + " " + val );
        });

        System.out.println("Sorted Value");

        //Comparator use
        List<Map.Entry<Integer , String>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list , new Comparator<Map.Entry<Integer, String>>(){
            @Override
            public int compare(Map.Entry<Integer,String> o1 , Map.Entry<Integer,String> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });

//        list.forEach( entry -> {
//            System.out.println(entry.getKey() + " " + entry.getValue() );
//        });


        int len = list.size();
        for(int i = 0 ; i < len ; i++){
            System.out.println(list.get(i).getValue());
        }



    }
}
