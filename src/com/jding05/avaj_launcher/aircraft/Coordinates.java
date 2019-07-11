package com.jding05.avaj_launcher.aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitudeDiff) {
        this.longitude += longitudeDiff;
    }

    public void setLatitude(int latitudeDiff) {
        this.latitude += latitudeDiff;
    }

    public void setHeight(int heightDiff) {
        this.height += heightDiff;
        if (this.height > 100) {
            this.height = 100;
        } else if (this.height < 0) {
            this.height = 0;
        }
    }
}
