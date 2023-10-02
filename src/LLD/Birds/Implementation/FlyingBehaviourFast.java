package LLD.Birds.Implementation;

import LLD.Birds.interfaces.FlyableBehaviour;

public class FlyingBehaviourFast implements FlyableBehaviour {
    @Override
    public void makeFly() {
        System.out.println("Flying fast");
    }
}
