package model;

import java.util.List;

public class Meal {
    private String name;
    private List<String> ingredients;
    private int caloriesPerStoGram;
    private int gram;
    private int pricePerStoGram;
    private String type;

    public Meal() {

    }

    public Meal(MealBuilder mealBuilder) {
        this.name = mealBuilder.name;
        this.ingredients = mealBuilder.ingredients;
        this.caloriesPerStoGram = mealBuilder.caloriesPerStoGram;
        this.gram = mealBuilder.gram;
        this.pricePerStoGram = mealBuilder.pricePerStoGram;
        this.type = mealBuilder.type;
    }

    public static class MealBuilder {
        private String name;
        private List<String> ingredients;
        private int caloriesPerStoGram;
        private int gram;
        private int pricePerStoGram;
        private String type;

        public MealBuilder() {
        }

        public MealBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MealBuilder ingredients(List<String> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public MealBuilder caloriesPerStoGram(int caloriesPerStoGram) {
            this.caloriesPerStoGram = caloriesPerStoGram;
            return this;
        }


        public MealBuilder gram(int gram) {
            this.gram = gram;
            return this;
        }

        public MealBuilder pricePerStoGram(int pricePerStoGram) {
            this.pricePerStoGram = pricePerStoGram;
            return this;
        }


        public MealBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getCaloriesPerStoGram() {
        return caloriesPerStoGram;
    }

    public int getGram() {
        return gram;
    }

    public int getPricePerStoGram() {
        return pricePerStoGram;
    }

    public String getType() {
        return type;
    }
}
