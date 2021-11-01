import model.Drink;
import model.Meal;
import model.MealType;
import model.MenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateMenuTests {

    private List<Meal> mealList = new ArrayList<>(Arrays.asList(new Meal(), new Meal()));

    @Test
    void getEmptyMenu() {
        List<MenuItem> actual = new Menu().generate();
        List<MenuItem> expected = new ArrayList<>();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getMenuIsNotNull() {
        MealType mealType1 = new MealType();
        List<MealType> mealTypeList = new ArrayList<>();
        //mealTypeList.add(mealType1);
        Menu menu = new Menu();
        List<MenuItem> menuCategories = menu.generate();

        Assertions.assertNotNull(menuCategories);
    }

    @Test
    void getOneSupperMenu() {
        MealType supper = new MealType("Supper");
        List<MenuItem> actualMenu = new Menu().generate(supper);


        List<MenuItem> expected = Arrays.asList(
                new MenuItem(supper, mealList, new Drink())
        );

        Assertions.assertEquals(actualMenu.size(), expected.size());
    }

    @Test
    void getMultipleMealsMenu() {
        MealType supper = new MealType("Supper");
        MealType breakfast = new MealType("Breakfast");
        List<MenuItem> actualMenu = new Menu().generate(breakfast, supper);

        List<MenuItem> expected = Arrays.asList(
                new MenuItem(breakfast, mealList, new Drink()),
                new MenuItem(breakfast, mealList, new Drink())
        );

        Assertions.assertEquals(actualMenu.size(), expected.size());
    }

    @Test
    void getMealNameFromMenu() {
        MealType supper = new MealType("Supper");
        List<MenuItem> actualMenu = new Menu().generate(supper);

        String expexted1 = "Гречаний суп";
        String expexted2 = "Борщ";

        Assertions.assertTrue(actualMenu.get(0).getMeals().get(0).getName().equals(expexted1) ||
                actualMenu.get(0).getMeals().get(0).getName().equals(expexted2));
    }

    @Test
    void getDrinkNameFromMenu() {
        MealType supper = new MealType("Supper");
        List<MenuItem> actualMenu = new Menu().generate(supper);

        String expexted1 = "Кока кола Standart";
        String expexted2 = "Чай обліпиховий";
        String expexted3 = "Чай ромашковий";

        Assertions.assertTrue(actualMenu.get(0).getDrink().getName().equals(expexted1) ||
                actualMenu.get(0).getMeals().get(0).getName().equals(expexted2) ||
                actualMenu.get(0).getMeals().get(0).getName().equals(expexted3)
        );
    }

    @Test
    void getMealsSizeFromMenu() {
        MealType supper = new MealType("Supper");
        List<MenuItem> actualMenu = new Menu().generate(supper);
        Assertions.assertEquals(actualMenu.get(0).getMeals().size(), 2);
    }

}
