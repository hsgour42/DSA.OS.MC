package FunctionalInterface;

import java.util.function.*;

public class Client {
    public static void main(String[] args){

        //Consumer and BiConsumer
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                return;
            }
        };


        BiConsumer<String , Integer> biConsumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                return;
            }
        };


        //Predicate & BiPredicate

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };


        BiPredicate<String, Integer> biPredicate = new BiPredicate<String, Integer>() {
            @Override
            public boolean test(String s, Integer integer) {
                return false;
            }
        };

        //Function & BiFunction
        Function<Integer , String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return null;
            }
        };

        BiFunction<Integer,String,Boolean> biFunction = new BiFunction<Integer, String, Boolean>() {
            @Override
            public Boolean apply(Integer integer, String s) {
                return null;
            }
        };

        //BinaryOperator
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return null;
            }
        };

        //Supplier
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };


    }
}
