package com.jding05.avaj_launcher.aircraft;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        idCounter++;
        return idCounter -1;
    }

}
