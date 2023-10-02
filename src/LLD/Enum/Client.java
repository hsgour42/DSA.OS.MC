package LLD.Enum;

public class Client {
    public static void main(String[] args) {
        for(TrafficLight trafficLight : TrafficLight.values()){
            System.out.println(trafficLight.name()  +" : " +  trafficLight.getDuration());
        }

        System.out.println(Color.Red);
    }
}
