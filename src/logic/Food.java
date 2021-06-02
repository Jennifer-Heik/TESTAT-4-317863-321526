/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Jen
 */
public class Food {
    private static int counter = 0;
    
    private int foodID, quantity;
    private String name, type;

    public Food(String name, int quantity,String type) {
        this.foodID = counter;
        counter++;
        this.name = name;
        this.quantity = quantity;
        this.type = type;

    }
    public int getFoodID() {
        return foodID+1;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;

    }
}


