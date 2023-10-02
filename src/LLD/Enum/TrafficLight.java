package LLD.Enum;

public enum TrafficLight {
    RED(1),
    GREEN(2 ),
    YELLOW(3);
    private final int duration;

    TrafficLight(int i ) {
        this.duration = i;
    }

    public int getDuration(){
        return duration;
    }
}
