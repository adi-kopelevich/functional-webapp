package sample.design.patterns.builder;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sample.design.patterns.buider.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class MealBuilderTest {

    MealBuilder mealBuilder;

    @Before
    public void init() {
        mealBuilder = new MealBuilder();
    }

    @After
    public void tearDown() {
        mealBuilder = null;
    }

    @Test
    public final void whenCallToPrepareVegMealThanGetMealWithVegBurgerAndCoke() {
        Set<Item> items = new HashSet<Item>();
        Meal meal = mealBuilder.prepareVegMeal();
        items.addAll(meal.getItems());
        Assert.assertTrue(meal.getItems().contains(new VeggieBurger()));
        Assert.assertTrue(meal.getItems().contains(new Coke()));
    }

}
