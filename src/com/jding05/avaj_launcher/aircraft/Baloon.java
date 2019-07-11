package com.jding05.avaj_launcher.aircraft;

import com.jding05.avaj_launcher.simulator.Logger;
import com.jding05.avaj_launcher.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch(weather) {
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                Logger.log("Baloon#" + name + "(" + id + "): " + "Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                coordinates.setHeight(coordinates.getHeight() - 5);
                Logger.log("Baloon#" + name + "(" + id + "): " + "Damn you rain! You messed up my baloon");
                break;
            case "FOG":
                coordinates.setHeight(coordinates.getHeight() -3);
                Logger.log("Baloon#" + name + "(" + id + "): " + "There is so much fog, I can't see shit.");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 5);
                Logger.log("Baloon#" + name + "(" + id + "): " + "It's snowing. We're  gonna crash.");
                break;
            default:
                System.out.println("Invalid weather");
                break;
        }
        if (coordinates.getHeight() == 0) {
            Logger.log("Baloon#" + name + "(" + id + "): landing.");
            Logger.log("Tower says: Baloon#" + name + "(" + id + "): unregistered from weather tower");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger.log("Tower says: Baloon#" + name + "(" + id + ")" + "registered to weather tower");
    }
}
