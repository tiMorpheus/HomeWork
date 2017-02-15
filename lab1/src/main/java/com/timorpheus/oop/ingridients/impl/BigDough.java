package com.timorpheus.oop.ingridients.impl;

import com.timorpheus.oop.ingridients.Dough;

public class BigDough extends Dough {

    String name = "Big dough";


    public BigDough(float diamert) {
        super(diamert);
    }

    public BigDough(float calories, float diamert) {
        super(calories, diamert);
    }

    @Override
    public String toString() {
        return name +": diametr" + getDiametr() + ". Calories: "+ getCalories();
    }



}
