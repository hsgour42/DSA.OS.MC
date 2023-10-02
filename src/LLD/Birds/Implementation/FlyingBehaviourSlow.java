package LLD.Birds.Implementation;

import LLD.Birds.interfaces.FlyableBehaviour;

public class FlyingBehaviourSlow implements FlyableBehaviour {
    @Override
    public void makeFly() {
        System.out.println("Flying slow");
    }
}
