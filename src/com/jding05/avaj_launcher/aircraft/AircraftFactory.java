package com.jding05.avaj_launcher.aircraft;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.toLowerCase().equals("baloon")) {
            return new Baloon(name, coordinates);
        } else if (type.toLowerCase().equals("helcopter")) {
            return new Helcopter(name, coordinates);
        } else if (type.toLowerCase().equals("jetplane")) {
            return new JetPlane(name, coordinates);
        } else {
            return null;
        }
    }
}
