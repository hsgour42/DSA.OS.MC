package Lambdas;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class Client {
    public static void main(String[] args){
        //Way to provide object of Functional Interface

        //1st way
        BiPredicate<String ,Integer  > way1 = new DemoClassBiP();

        //2nd way : Anonymous type
        BiPredicate<String , Integer> way2 = new BiPredicate<String, Integer>() {
            @Override
            public boolean test(String s, Integer integer) {
                return false;
            }
        };

        //3rd way : Lambda
        //object : Parameter : logic
        BiPredicate<String ,Integer> way3 = (str , minLength ) -> {
            return str.length() == minLength;
        };

        System.out.println(way3.test("Hello" , 6));


        BinaryOperator<String> binaryOperator = (s1 , s2) -> {
            return s1 + " " + s2;
        };

        BinaryOperator<String> binaryOperator1 = (s1 , s2) -> s1 + " " + s2;


        System.out.println(binaryOperator.apply("Himanshu" , "Singh"));
        System.out.println(binaryOperator1.apply("Vijay" , "Singh"));

    }
}
