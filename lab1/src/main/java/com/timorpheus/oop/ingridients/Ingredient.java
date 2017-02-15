package com.timorpheus.oop.ingridients;

public abstract class Ingredient {

    private String name;
    private float calories;

    public Ingredient() {

    }

    public Ingredient(float calories) {
        this.calories = calories;
    }

    public Ingredient(String name, float calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }


    @Override
    public abstract String toString();
}

