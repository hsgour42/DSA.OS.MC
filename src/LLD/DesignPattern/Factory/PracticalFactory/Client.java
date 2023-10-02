package LLD.DesignPattern.Factory.PracticalFactory;

public class Client {
    public static void main(String[] args) {
        Bird hen = BirdFactory.createBirdType(BirdType.HEN);
        System.out.println();
    }
}
