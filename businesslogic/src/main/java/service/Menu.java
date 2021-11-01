package service;

import model.Drink;
import model.Meal;
import model.MealType;
import model.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {

    private final MealSource mealSource;
    private final DrinkSource drinkSource;

    public Menu(MealSource mealSource, DrinkSource drinkSource) {
        this.mealSource = mealSource;
        this.drinkSource = drinkSource;
    }

    public List<MenuItem> generate(MealType... types) {
        List<MenuItem> mealCategoriesList = new ArrayList<>();

        for (MealType meal : types) {
            mealCategoriesList.add(getMenuCategory(meal));
        }

        return mealCategoriesList;
    }

    private MenuItem getMenuCategory(MealType day) {
        List<Meal> meals = mealSource.getMeals();
        Drink drink = drinkSource.getDrink();
        return new MenuItem(day, meals, drink);
    }

   /* private MenuItem getMealWithDesert() {
        return mealSource.getMeal("desert");
    }

    private MenuItem getMealWithDrink() {

    }

    private MenuItem getComplexMeal() {

    }
*/



    /* public List<MenuItem> getMenu(List<MealType> meals) {

         List<MenuItem> mealCategoriesList = new ArrayList<>();

         for (MealType meal : meals) {
             mealCategoriesList.add(getMenuCategory(meal));
         }

         return mealCategoriesList;
     }*/
}
