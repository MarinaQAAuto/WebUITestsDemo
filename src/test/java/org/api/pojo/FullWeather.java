package org.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FullWeather {
    public FWCoordinates coord;
    public FWWeather[] weather;
    public String base;

    public FWCoordinates getCoord() {
        return coord;
    }

    public void setCoord(FWCoordinates coord) {
        this.coord = coord;
    }

    public FWWeather[] getWeather() {
        return weather;
    }

    public void setWeather(FWWeather[] weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "FullWeather{" +
                "coord=" + coord +
                ", weather=" + Arrays.toString(weather) +
                ", base='" + base + '\'' +
                '}';
    }
}
