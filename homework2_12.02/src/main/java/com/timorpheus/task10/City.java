package com.timorpheus.task10;

import java.util.ArrayList;
import java.util.List;

public class City {

    String title;
    int population;
    private List<Street> streets = new ArrayList<>();


    public City(String title, int population){
        this.title = title;
        this.setPopulation(population);
    }

    public void addStreet(Street street){
        streets.add(street);
    }

    public List<Street> getStreets() {
        return streets;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        if (population <= 0){
            throw new IllegalArgumentException();
        }
        this.population = population;
    }

    public class Street {

        String title;
        int numberOfBuildings;
        double lengthOfStreet;
        StreetType streetType;

        public Street(String title, int numberOfBuildings, double lengthOfStreet, StreetType streetType) {
            this.title = title;
            this.numberOfBuildings = numberOfBuildings;
            this.lengthOfStreet = lengthOfStreet;
            this.streetType = streetType;
        }

        @Override
        public String toString() {
            return "Street{" +
                    "title='" + title + '\'' +
                    ", numberOfBuildings=" + numberOfBuildings +
                    ", lengthOfStreet=" + lengthOfStreet +
                    ", streetType=" + streetType +
                    '}';
        }
    }
}
