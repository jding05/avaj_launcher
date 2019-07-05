package com.jding05.avaj_launcher.simulator;

import com.jding05.avaj_launcher.aircraft.Flyable;
import java.util.ArrayList;

public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flayable> flayables = new ArrayList<Flyable>();



    public static void log(String message) {
        System.out.println(message);
    }
}
