package com.jding05.avaj_launcher.aircraft;

import com.jding05.avaj_launcher.simulator.Simulator;
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
            case "RAIN":

                break;


        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Simulator.log("Tower says: Baloon#" + this.name + "(" + this.id + ")" + "registered to weather tower");
    }
}