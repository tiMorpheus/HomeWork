package com.timorpheus.task7;

public class City {

    private String title;
    private int population;

    public City(String title, int population) {
        this.title = title;
        this.setPopulation(population);
    }

    public String getTitle() {
        return title;
    }

    public void setPopulation(int population) {
        if (population <= 0){
            throw new IllegalArgumentException();
        }

        this.population = population;
    }

    public int getPopulation() {
        return population;
    }
}
