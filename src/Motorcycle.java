import java.util.Random;

public class Motorcycle {
    Random rand = new Random();
    static int nameNumber = 1;
    int normalSpeed;
    String name;
    int distanceTravelled;

    public Motorcycle(){
        normalSpeed = 100;
        name = "Motorcycle " + nameNumber;
        distanceTravelled = 0;
        nameNumber ++;
    }

    public void decreaseSpeed(boolean isRain){
        if(isRain){
            normalSpeed -= rand.nextInt((50 - 5) + 1) + 5;
        } else {
            normalSpeed = 100;
        }
    }
    public void moveForAnHour(){

        distanceTravelled += normalSpeed;
    }

    public int getNormalSpeed(){

        return normalSpeed;
    }

    public String getName() {

        return name;
    }

    public int getDistanceTravelled() {

        return distanceTravelled;
    }
    public String getType(){
        return "Motorcycle";
    }
}
