package com.jding05.avaj_launcher.aircraft;

import com.jding05.avaj_launcher.simulator.Logger;
import com.jding05.avaj_launcher.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }


    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch(weather) {
            case "SUN":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(2);
                Logger.log("JetPlane#" + name + "(" + id + "): " + "This is hot.");
                break;
            case "RAIN":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                Logger.log("JetPlane#" + name + "(" + id + "): " + "It's raining. Better watch out for lightnings");
                break;
            case "FOG":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                Logger.log("JetPlane#" + name + "(" + id + "): " + "The fog is killing me. Request permission to land.");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 7);
                Logger.log("JetPlane#" + name + "(" + id + "): " + "OMG! Winter is coming!");
                break;
            default:
                System.out.println("Invalid weather");
                break;
        }
        if (coordinates.getHeight() == 0) {
            Logger.log("JetPlane#" + name + "(" + id + "): landing.");
            Logger.log("Tower says: JetPlane#" + name + "(" + id + "): unregistered from weather tower");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger.log("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + "registered to weather tower");
    }
}
