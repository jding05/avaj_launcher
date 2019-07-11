package com.jding05.avaj_launcher.simulator;

import com.jding05.avaj_launcher.aircraft.AircraftFactory;
import com.jding05.avaj_launcher.aircraft.Flyable;

import java.io.*;
import java.util.*;

public class Simulator {
    private static class NoArgumentException extends Exception {
        public NoArgumentException() {
            super();
        }
        public NoArgumentException(String msg) {
            super(msg);
        }
    }
    private static class InvalidFlyableException extends Exception {
        public InvalidFlyableException() {
            super();
        }
        public InvalidFlyableException(String msg) {
            super(msg);
        }
    }

    private static List<Flyable> flyables = new ArrayList<Flyable>();


    private static void checkArgument(String[] args) throws NoArgumentException {
        if (args.length < 1) {
            throw new NoArgumentException("Failed: run the program with a scenario file");
        }
    }


    public static void main(String[] args) {
        try {
            checkArgument(args);
        } catch (NoArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        WeatherTower weatherTower = new WeatherTower();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line == null) {
                return ;
            }
            int nbSimulations = Integer.parseInt(line.split(" ")[0]);
            if (nbSimulations < 0) {
                System.out.println("Invalid simulation counts :" + nbSimulations);
                System.exit(1);
            }
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(" ");
                Flyable flyable = AircraftFactory.newAircraft(info[0], info[1],
                        Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]));
                if (flyable == null) {
                    System.out.println("Error: Invalid aircraft type");
                    throw new InvalidFlyableException();
                }
                flyables.add(flyable);
            }
            for (Flyable flyable : flyables) {
                flyable.registerTower(weatherTower);
            }
            for (int i = 0; i < nbSimulations; i++) {
                weatherTower.changeWeahter();
            }
        } catch (NumberFormatException|InvalidFlyableException|IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            Logger.close();
        }

    }

}
