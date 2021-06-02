/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;

/**
 *
 * @author Jen
 */
public class FoodManager {
    private final static ArrayList<Food> Foods = new ArrayList<Food>();

    public static ArrayList<Food> getFoods() {
        return Foods;
    }

    public static void addFood(Food food) {
        food.setFoodID(Foods.size());
        Foods.add(food);
    }

    public static void deleteFood(int id) {
        Food food = getFood(id);
            Foods.remove(food);
        for (int i = 0; i < Foods.size(); i++) {
            food = (Food) Foods.get(i);
            food.setFoodID(i);
        }
    }

    public static Food getFood(int id) {
        for (Food food : Foods) {
            if (food.getFoodID() == id) {
                return food;}
    }
        
        return null;
    }

}
