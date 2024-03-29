package com.jding05.avaj_launcher.weather;

import com.jding05.avaj_launcher.aircraft.Coordinates;

public class WeatherProvider {
    private volatile static WeatherProvider weatherProvider;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private final int prime = 31;
    private final int largePrime = 101;

    private WeatherProvider() {};

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            synchronized (WeatherProvider.class) {
                if (weatherProvider == null) {
                    weatherProvider = new WeatherProvider();
                }
            }
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(coordinates.getLatitude() * prime * prime % largePrime + coordinates.getLongitude() * prime % largePrime + coordinates.getHeight()) % 4];
    }

}
