package com.timorpheus.task7;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private String title;
    private List<District> districts = new ArrayList<>();
    private City centerCity;

    public Area(String title, City centerCity) {
        this.title = title;
        this.centerCity = centerCity;
    }

    public String getTitle() {
        return title;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public City getCenterCity() {
        return centerCity;
    }

    public String getCenterCityTitle() {
        return centerCity.getTitle();
    }

    public void setCenterCity(City centerCity) {
        this.centerCity = centerCity;
    }

    public void addDistrict(District district) {
        this.districts.add(district);
    }

    public double calculateSquare() {
        double square = 0;
        for (District district : districts) {
            square += district.getSquare();
        }
        return square;
    }

}
