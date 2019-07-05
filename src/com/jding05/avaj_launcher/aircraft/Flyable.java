package com.jding05.avaj_launcher.aircraft;

import com.jding05.avaj_launcher.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}