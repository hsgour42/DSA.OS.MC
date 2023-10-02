package LLD.DesignPattern.Factory.PracticalFactory;

public class BirdFactory {
    public static Bird createBirdType(BirdType birdType){
        return switch (birdType){
            case HEN -> new Hen();
            case CROW -> new Crow();
            case PEACOCK -> new Peacock();
            case SPARROW -> new Sparrow();
            default -> new Bird();
        };
    }

    public static Bird createBirdTypeFromStringType(String birdType){
       if (birdType.equalsIgnoreCase("HEN")){
           return new Hen();
        }else if (birdType.equalsIgnoreCase("CROW")){
           return new Crow();
        } else if (birdType.equalsIgnoreCase("Sparrow")) {
           return new Sparrow();
       } else if (birdType.equalsIgnoreCase("peacock")) {
           return new Peacock();
       }else{
           return new Bird();
       }
    }
}
