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
            this.setNumberOfBuildings(numberOfBuildings);
            this.setLengthOfStreet(lengthOfStreet);
            this.streetType = streetType;
        }


        public double clearStreet(){

            double i = 0.0;
            for (; i <= lengthOfStreet; i++){
                System.out.println("clear street " + this.title + " on " + i + " meter" );
            }
            return i;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getNumberOfBuildings() {
            return numberOfBuildings;
        }

        public void setNumberOfBuildings(int numberOfBuildings) {
            if( numberOfBuildings < 0){
                throw new IllegalArgumentException();
            }
            this.numberOfBuildings = numberOfBuildings;
        }

        public double getLengthOfStreet() {
            return lengthOfStreet;
        }

        public void setLengthOfStreet(double lengthOfStreet) {
            if( lengthOfStreet < 0){
                throw new IllegalArgumentException();
            }
            this.lengthOfStreet = lengthOfStreet;
        }

        public StreetType getStreetType() {
            return streetType;
        }

        public void setStreetType(StreetType streetType) {
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
