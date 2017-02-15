package com.timorpheus.oop.builder.impl;

import com.timorpheus.oop.builder.PizzaBuilder;
import com.timorpheus.oop.ingridients.impl.BigDough;
import com.timorpheus.oop.ingridients.impl.Chedder;
import com.timorpheus.oop.ingridients.impl.SuperRedHotChilliPepperSouce;

public class HawaiiPizzaBuilder extends PizzaBuilder {
    @Override
    public void prepare() {
        System.out.println("Preparing hawaii...");
        pizza.setDough(new BigDough(1300, 30));
        pizza.setCheese(new Chedder(700));
        pizza.setSauce(new SuperRedHotChilliPepperSouce(true, 1130));

    }
}
