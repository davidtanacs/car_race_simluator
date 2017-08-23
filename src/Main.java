import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.*;
import java.lang.*;

public class Main {

    static boolean isRaining; //30% chance of rain every hour
    static int breakDownsTurnLeft;

    public static void main(String[] args) {
        HashMap racers = new HashMap();
        ArrayList racersList = new ArrayList();
        racers = createVehicles();
        racersList = simulateRace(racers);
        printRaceResults(racersList);


    }

    private static boolean isRaining() {
        Random rand = new Random();
        int chance = rand.nextInt(10);
        if (chance < 3) {
            isRaining = true;
        } else {
            isRaining = false;
        }
        return isRaining;
    }

    // creates 10 cars, 10 trucks and 10 motorcycles
    private static HashMap createVehicles() {
        ArrayList<Car> carsArray = new ArrayList<Car>(10);
        ArrayList<Motorcycle> motorcyclesArray = new ArrayList<Motorcycle>(10);
        ArrayList<Truck> trucksArray = new ArrayList<Truck>(10);
        HashMap<String, List> allRacers = new HashMap<String, List>();
        for (int i = 0; i < 10; i++) {
            Car cars = new Car();
            carsArray.add(cars);

            Motorcycle motorcycles = new Motorcycle();
            motorcyclesArray.add(motorcycles);

            Truck trucks = new Truck();
            trucksArray.add(trucks);
        }
        allRacers.put("cars", carsArray);
        allRacers.put("motorcycles", motorcyclesArray);
        allRacers.put("trucks", trucksArray);
        return allRacers;
    }

    // simulates the race by calling moveForAnHour() on every vehicle 50 times and setting whether its raining.
    public static ArrayList simulateRace(HashMap<String, List> racers) {
        ArrayList allRacer = new ArrayList();
        for (int i = 0; i < 10; i++) {
            for (HashMap.Entry<String, List> entry : racers.entrySet()) {
                allRacer.add(entry.getValue().get(i));
            }
        }
        for (int i = 0; i < 50; i++) {
            boolean isRain = isRaining();
            for (Object racer : allRacer) {
                if (racer.toString().startsWith("C")) {
                    Car car = Car.class.cast(racer);
                    car.setSpeedLimit(70, isRain);
                    car.moveForAnHour();
                } else if (racer.toString().startsWith("M")) {
                    Motorcycle motorcycle = Motorcycle.class.cast(racer);
                    motorcycle.decreaseSpeed(isRain);
                    motorcycle.moveForAnHour();
                } else {
                    Truck truck = Truck.class.cast(racer);
                    breakDownsTurnLeft = truck.breakDownsTurnLeft();
                    truck.moveForAnHour(breakDownsTurnLeft);
                }
            }
        }
        return allRacer;
    }

    // prints each vehicle's name, distance traveled ant type.
    public static void printRaceResults(ArrayList allracer) {
        for (Object racer : allracer) {
            if (racer.toString().startsWith("C")) {
                Car car = Car.class.cast(racer);
                System.out.println("name: " + car.getName() + ", Travelled distance: " + car.getDistanceTravelled() + ", Type: " + car.getType());
                System.out.println();
            } else if (racer.toString().startsWith("M")) {
                Motorcycle motorcycle = Motorcycle.class.cast(racer);
                System.out.println("name: " + motorcycle.getName() + ", Travelled distance: " + motorcycle.getDistanceTravelled() + ", Type: " + motorcycle.getType());
                System.out.println();
            } else {
                Truck truck = Truck.class.cast(racer);
                System.out.println("name: " + truck.getName() + ", Travelled distance: " + truck.getDistanceTravelled() + ", Type: " + truck.getType());
                System.out.println();
            }
        }
    }
}