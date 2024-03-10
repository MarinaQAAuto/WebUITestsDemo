package org.api.pojo;

public class FWCoordinates {
    public double lon;
    public double lat;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "FWCoordinates{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
