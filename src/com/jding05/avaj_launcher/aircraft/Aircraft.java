package com.jding05.avaj_launcher.aircraft;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = getId();
    }

    private long getId() {
        idCounter++;
        return idCounter -1;
    }

}
