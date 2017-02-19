package com.timorpheus.oop.ingridients.impl;

import com.timorpheus.oop.ingridients.Sauce;

public class SuperRedHotChiliPepperSouce extends Sauce {

    String name = "Red hot chili sauce";

    public SuperRedHotChiliPepperSouce(boolean isHot, float calories) {
        super(isHot, calories);
    }


    @Override
    public String toString() {
        return name + ". isHot" + isHot() + ". Calories= " + getCalories();
    }
}
