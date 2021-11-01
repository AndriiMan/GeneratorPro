package mocks;

import model.Meal;
import service.MealSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MealSourceMock implements MealSource {
    @Override
    public Meal getMeal() {
        return null;
    }

    @Override
    public List<Meal> getMeals() {
        return randomMeal();
    }

    private List<Meal> randomMeal() {
        List<String> ingredientsBorshch = Arrays.asList("Зелень", "Буряк", "Цибуля", "М'ясо");
        List<String> ingredientskasha1 = List.of("Гречка");
        List<String> ingredientssupgrechany = Arrays.asList("Зелень", "Гречка", "Цибуля", "Картопля");

        Meal borshch = new Meal.MealBuilder()
                .name("Борщ")
                .ingredients(ingredientsBorshch)
                .caloriesPerStoGram(110)
                .gram(60)
                .pricePerStoGram(50)
                .type("Суп")
                .build();

        Meal kasha1 = new Meal.MealBuilder()
                .name("Гречана каша")
                .ingredients(ingredientskasha1)
                .caloriesPerStoGram(80)
                .gram(120)
                .pricePerStoGram(250)
                .type("Каша")
                .build();

        Meal supgrechany = new Meal.MealBuilder()
                .name("Гречаний суп")
                .ingredients(ingredientssupgrechany)
                .caloriesPerStoGram(115)
                .gram(100)
                .pricePerStoGram(150)
                .type("Суп")
                .build();

        List<Meal> mealsList = Arrays.asList(borshch, kasha1, supgrechany);

        return Stream.concat(getMealsSup(mealsList).stream(), getMealsKasha(mealsList).stream())
                .collect(Collectors.toList());
    }


    private List<Meal> getMealsSup(List<Meal> mealsList) {
        Collections.shuffle(mealsList);
        return mealsList.stream().filter(name -> name.getType().equals("Суп"))
                .limit(1)
                .collect(Collectors.toList());
    }

    private List<Meal> getMealsKasha(List<Meal> mealsList) {
        Collections.shuffle(mealsList);
        return mealsList.stream().filter(name -> name.getType().equals("Каша"))
                .limit(1)
                .collect(Collectors.toList());
    }
}
