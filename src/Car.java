import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class Car {
    Random rand = new Random();
    int normalSpeed;
    String name;
    String nameTry;
    String[] possibleCarNameArray = {"Albatross",
            "Eternity",
            "Inception",
            "Twister",
            "Striker",
            "Spire",
            "Scorpion",
            "Cosmos",
            "Supremacy",
            "Hollo"};
    List<String> possibleCarNameList = new ArrayList<String>(Arrays.asList(possibleCarNameArray));
    static int i = 9;
    static int j = 0;

    private int distanceTravelled = 0;

    Main main = new Main();


    public Car(){
        name = possibleCarNameList.get(i) + " " + possibleCarNameList.get(j);
        i--;
        j++;
        normalSpeed = rand.nextInt(110 - 80 + 1) + 80;
        }


    public void setSpeedLimit(int limit, boolean isRain){
        if(isRain){
            normalSpeed = limit;
        } else {
            normalSpeed = rand.nextInt(110 - 80 + 1) + 80;
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
        return "Car";
    }
}
