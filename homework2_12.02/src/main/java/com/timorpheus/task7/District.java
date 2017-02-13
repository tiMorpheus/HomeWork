package com.timorpheus.task7;

import java.util.ArrayList;
import java.util.List;

public class District {

    private String title;
    private List<City> cities = new ArrayList<>();
    private double square;

    public District(String title, double square) {
        this.title = title;
        this.square = square;
    }

    public String getTitle() {
        return title;
    }

    public List<City> getCities() {
        return cities;
    }

    public double getSquare() {
        return square;
    }

    public void addCity(City city) {
        cities.add(city);
    }
}
