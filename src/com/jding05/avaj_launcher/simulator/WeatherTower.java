package com.jding05.avaj_launcher.simulator;

import com.jding05.avaj_launcher.aircraft.Coordinates;
import com.jding05.avaj_launcher.weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeahter() {
        conditionsChanged();
    }
}
