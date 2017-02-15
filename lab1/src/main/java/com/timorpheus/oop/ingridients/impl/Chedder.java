package com.timorpheus.oop.ingridients.impl;

import com.timorpheus.oop.ingridients.Cheese;


public class Chedder extends Cheese {

    String name = "Chedder cheese";


    public Chedder(float calories) {
        super(calories);
    }


    @Override
    public String toString() {
        return name + ". Calories: "+ getCalories();
    }
}
