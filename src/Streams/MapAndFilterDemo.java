package Streams;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MapAndFilterDemo {
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
        List<Integer> list = Arrays.asList(2,4,5,12,44,43,85,17,7,24);

        //give only even number to me
        //filter method of stream
        System.out.println(list.stream().filter( x -> x % 2 == 0).toList());
        //list converted to stream
        //streams will loop over element
        //pass every element to filter
        //filters will pass every element to lambda
        //lambda will return true or false
        //if get true, it will include the element in result
        //if get false, it will reject the element



        Car car2 = new Car(600 , 2000  , "B");
        Car car1 = new Car(100 , 1000  , "A");
        Car car3 = new Car(300 , 3000  , "C");
        Car car4 = new Car(600 , 6000  , "D");
        Car car5 = new Car(400 , 4000  , "E");

        List<Car> carList = Arrays.asList(car1,car2,car3,car4,car5);

        System.out.println(carList.stream().filter( x -> x.price > 3000).toList());


        List<Integer> prices = carList.stream().map( c -> c.price).toList();
        System.out.println(prices);

        System.out.println("Map condition return : " + carList.stream().map(c -> c.price > 2000).toList());

        List<Integer> filterPrice = carList.stream().filter( x -> x.price > 3000).map( c -> c.price).toList();
        System.out.println(filterPrice);

        List<Car> brandFilter = carList.stream().filter( x -> x.brand.startsWith("C")).toList();
        System.out.println(brandFilter);


        Comparator<Car> comparatorPrice = (c1,c2) -> {
            return c1.price - c2.price;
        };

        carList.stream().sorted(comparatorPrice).forEach(System.out::println);

         Car minCarPrice = carList.stream().min(comparatorPrice).get();
         System.out.println("min price : " + minCarPrice);

        //carList.stream().forEach( x -> System.out.println(x));
        System.out.println(carList.stream().allMatch( x -> x.price == 2000));

        System.out.println();



    }
}
