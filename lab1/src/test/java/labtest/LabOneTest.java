package labtest;

import com.timorpheus.oop.builder.PizzaBuilder;
import com.timorpheus.oop.builder.impl.HawaiiPizzaBuilder;
import com.timorpheus.oop.chef.Chef;
import com.timorpheus.oop.ingridients.Ingredient;
import com.timorpheus.oop.ingridients.impl.BigDough;
import com.timorpheus.oop.ingridients.impl.Chedder;
import com.timorpheus.oop.pizza.Pizza;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LabOneTest {

    Chef chef;
    PizzaBuilder hawaiiPizzaBuilder;
    Pizza pizza;

    @Before
    public void init() {
        chef = new Chef();
        hawaiiPizzaBuilder = new HawaiiPizzaBuilder();

        chef.setPizzaBuilder(hawaiiPizzaBuilder);
        chef.createPizza();

        pizza = chef.getPizza();
    }


    @Test
    public void getPizzaCaloriesTest(){
        assertEquals(3130.0, pizza.getPizzaCalories(), 1);
    }

    @Test
    public void sortByCaloriesTest(){
        pizza.sortByCalories();

        StringBuilder builder = new StringBuilder();

        for (Ingredient ingredient : pizza.getIngredients()){
            builder.append(ingredient.getCalories()+ " ");
        }

        assertEquals("700.0 1130.0 1300.0 ", builder.toString());
    }

    @Test
    public void addIngredientTest(){
        pizza.addIngredients(new Chedder(100));

        assertEquals(3230.0, pizza.getPizzaCalories(), 1);
    }


    @Test
    public void getIngredientsByRangeOfCaloriesTest(){

        List<Ingredient> ingredients = pizza.getIngredientsByRangeOfCalories(700.0f, 1200.0f);

        assertEquals(2, ingredients.size());
    }


    //EXCEPTION TESTING

    @Test
    public void illegalArgGetIngrByRangeTest(){
        pizza.addIngredients(new Chedder(0));

        List<Ingredient> i = pizza.getIngredientsByRangeOfCalories(0,0);
        assertEquals(1, i.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgGetIngrByRangeTest2(){
        pizza.getIngredientsByRangeOfCalories(-1, 2);
    }


    @Test(expected = IllegalArgumentException.class)
    public void illegalArgGetIngrByRangeTest3(){
        pizza.getIngredientsByRangeOfCalories(3, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void duplicateDougthTest(){
        pizza.addIngredients(new BigDough(11,11));
    }

}
