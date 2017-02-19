package com.timorpheus.oop.builder.impl;

import com.timorpheus.oop.builder.PizzaBuilder;
import com.timorpheus.oop.ingridients.impl.BigDough;
import com.timorpheus.oop.ingridients.impl.Chedder;
import com.timorpheus.oop.ingridients.impl.SuperRedHotChiliPepperSouce;

public class CheesePizzaBuilder extends PizzaBuilder {

    @Override
    public void prepare() {
        System.out.println("Preparing cheezy...");
        pizza.setDough(new BigDough(1000, 50));
        pizza.setCheese(new Chedder(500));
        pizza.setSauce(new SuperRedHotChiliPepperSouce(true, 1330));

    }
}
