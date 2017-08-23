import java.util.Random;

public class Truck {
    Random rand = new Random();
    int normalSpeed;
    int distanceTravelled;
    int breakDownsTurnLeft;
    int name;
    int chanceForBreakDown;
    boolean isBreakDown;

    public Truck(){
        normalSpeed = 100;
        distanceTravelled = 0;
        breakDownsTurnLeft = 0;
        name = rand.nextInt(1000) + 1;
    }

    public int breakDownsTurnLeft(){
        chanceForBreakDown = rand.nextInt((20 - 0) + 1);
        if(chanceForBreakDown == 1 && breakDownsTurnLeft == 0){
            breakDownsTurnLeft = 2;
        } else if(breakDownsTurnLeft > 0){
            breakDownsTurnLeft--;
        }
        return breakDownsTurnLeft;
    }

    public void moveForAnHour(int breakDownsTurnLeft){
        if(breakDownsTurnLeft > 0){
            breakDownsTurnLeft--;
        } else {
            distanceTravelled += normalSpeed;
        }
    }

    public int getNormalSpeed(){
        return normalSpeed;
    }

    public int getName() {
        return name;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public String getType(){
        return "Truck";
    }

}
