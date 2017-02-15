package com.timorpheus.oop.builder.impl;

import com.timorpheus.oop.builder.PizzaBuilder;
import com.timorpheus.oop.ingridients.impl.BigDough;
import com.timorpheus.oop.ingridients.impl.Chedder;
import com.timorpheus.oop.ingridients.impl.SuperRedHotChilliPepperSouce;

public class VeganPizzaBuilder extends PizzaBuilder {

    @Override
    public void prepare() {
        System.out.println("Preparing vegan pizza...");
        pizza.setDough(new BigDough(100, 10));
        pizza.setCheese(new Chedder(100));
        pizza.setSauce(new SuperRedHotChilliPepperSouce(true, 130));

    }

}
