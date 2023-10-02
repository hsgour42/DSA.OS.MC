package LLD.Birds;

import LLD.Birds.Implementation.FlyingBehaviourFast;
import LLD.Birds.Implementation.FlyingBehaviourSlow;
import LLD.Birds.birdtype.Crow;
import LLD.Birds.interfaces.Flyable;

public class Client {
    public static void main(String[] args) {
        Bird crow = new Crow(new FlyingBehaviourFast());
        crow.fly();
        System.out.println();
    }
}
