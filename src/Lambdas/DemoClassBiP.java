package Lambdas;

import java.util.function.BiPredicate;

public class DemoClassBiP implements BiPredicate<String , Integer> {
    @Override
    public boolean test(String s, Integer integer) {
        return false;
    }
}
