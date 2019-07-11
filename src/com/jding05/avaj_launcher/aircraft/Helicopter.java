package com.jding05.avaj_launcher.aircraft;

import com.jding05.avaj_launcher.simulator.Logger;
import com.jding05.avaj_launcher.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

     Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }


    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch(weather) {
            case "SUN":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                Logger.log("Helicopter#" + name + "(" + id + "): " + "This is hot.");
                break;
            case "RAIN":
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                Logger.log("Helicopter#" + name + "(" + id + "): " + "It's raining.");
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                Logger.log("Helicopter#" + name + "(" + id + "): " + "I can't see shit.");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 12);
                Logger.log("Helicopter#" + name + "(" + id + "): " + "My rotor is going to freeze!");
                break;
            default:
                System.out.println("Invalid weather");
                break;
        }
        if (coordinates.getHeight() == 0) {
            Logger.log("Helicopter#" + name + "(" + id + "): landing.");
            Logger.log("Tower says: Helcopter#" + name + "(" + id + "): unregistered from weather tower");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger.log("Tower says: Helcopter#" + this.name + "(" + this.id + ")" + "registered to weather tower");
    }

}
