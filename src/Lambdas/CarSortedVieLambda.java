package Lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.StreamSupport;

public class CarSortedVieLambda {
    static class Car{
        int speed;
        int price;
        String brand;

        public Car(int speed, int price, String brand) {
            this.speed = speed;
            this.price = price;
            this.brand = brand;
        }

        @Override
        public String toString() {
            return "[Speed=" + this.speed + ", Price=" +  this.price + ", Brand=" + this.brand   + "]\n";
        }
    }
    public static void main(String[] args) {
        Car car1 = new Car(100 , 1000  , "A");
        Car car2 = new Car(600 , 2000  , "B");
        Car car3 = new Car(300 , 3000  , "C");
        Car car4 = new Car(600 , 6000  , "D");
        Car car5 = new Car(400 , 4000  , "E");

        List<Car> carList = Arrays.asList(car1,car2,car3,car4,car5);
        System.out.println(carList);

        Comparator<Car> speedCompare = (c1 , c2) -> c1.speed - c2.speed;

        Comparator<Car> priceCompare = (c1 , c2) -> c1.price - c2.price;

        Comparator<Car> brandCompare = (c1 , c2) -> c1.brand.compareTo(c2.brand);

        Collections.sort(carList,speedCompare);
        System.out.println(carList);
        Collections.sort(carList ,priceCompare);
        System.out.println(carList);

        //Using Lambda To Sort it
        Collections.sort(carList ,  (c1 , c2) ->  c1.speed -  c2.speed);
        System.out.println(carList);






    }
}
