package com.timorpheus.task7;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String title;
    private List<Area> areas = new ArrayList<>();
    private City capital;

    public Country(String title, City capital) {
        this.title = title;
        this.capital = capital;
    }

    public String getTitle() {
        return title;
    }

    public String getCapital() {
        return capital.getTitle();
    }

    public List<Area> getAreas() {
        return areas;
    }

    public int getAreasAmount() {
        return areas.size();
    }

    public void addAreas(Area... area) {
        if (area == null){
            throw new IllegalArgumentException();
        }

        for (Area a : area) {
            areas.add(a);
        }
    }

    public double calculateSquare() {
        double square = 0;
        for (Area area : areas) {
            square += area.calculateSquare();
        }
        return square;
    }


    /**
     * Methods
     **/

    public void printCapital() {

        System.out.println("Capital of " + this.title + " is " + this.getCapital());
    }

    public void printSquare() {
        System.out.println("Square of " + this.title + " = " + this.calculateSquare());
    }

    public void printAreas() {
        System.out.println("Numbers of areas = " + areas.size());
        System.out.printf("%-4s %-15s %-10s %n", "", "Title area", "center city");
        int i = 1;
        for (Area area : areas) {
            System.out.printf("%-4d %-15s %-10s %n", i++, area.getTitle(), area.getCenterCityTitle());
        }
    }
}
