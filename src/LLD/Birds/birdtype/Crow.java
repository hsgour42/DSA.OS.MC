package LLD.Birds.birdtype;

import LLD.Birds.Bird;
import LLD.Birds.interfaces.Flyable;
import LLD.Birds.interfaces.FlyableBehaviour;

public class Crow extends Bird implements Flyable {
    FlyableBehaviour flyableBehaviour;

     public Crow(FlyableBehaviour flyableBehaviour){
        this.flyableBehaviour = flyableBehaviour;
    }

    @Override
    public void fly() {
            flyableBehaviour.makeFly();
    }
}
