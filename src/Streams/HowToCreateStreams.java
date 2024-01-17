package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//A wrapper over data source for operations on data
public class HowToCreateStreams {
    public static void main(String[] args) {

        //array to stream
        Integer[] arr = {10,30,20,50,40};
        Stream<Integer> s1 = Stream.of(arr);


        //items to stream
        Stream<Integer> s2 = Stream.of(10,30,20,60,50);


        //List/Collection to stream
        List<Integer> list = Arrays.asList(10,30,20,50,40);
        Stream<Integer> s3 = list.stream();


        //use builder to create stream
        Stream.Builder<Integer> sb = Stream.builder();
        sb.accept(10);
        sb.accept(30);
        sb.accept(20);
        sb.accept(50);
        sb.accept(40);
        Stream<Integer> s4 = sb.build();

    }
}
