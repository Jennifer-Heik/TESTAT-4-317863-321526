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
public class AnimalManager {

    private final static ArrayList<Animal> Animals = new ArrayList<Animal>();

    public static ArrayList<Animal> getAnimals() {
        return Animals;
    }

    public static void addAnimal(Animal animal) {
        animal.setAnimalID(Animals.size());
        Animals.add(animal);
    }

    public static void deleteAnimal(int id) {
        Animal animal = getAnimal(id);
        
            Animals.remove(animal);
        
        for (int i = 0; i < Animals.size(); i++) {
            animal = (Animal) Animals.get(i);
            animal.setAnimalID(i);
        }
    }

    public static Animal getAnimal(int id) {
        for (Animal animal : Animals) {
            if (animal.getAnimalID() == id) {
                return animal;
            }
        }
        System.out.println("No animal found!");
        return null;
    }

    /*public static void updateAnimal(int id, String name, int age, boolean health_status, boolean feeding_status, String gender, String specific_type) {
        Animal animal = getAnimal(id);
        if (animal != null) {
            int index = Animals.indexOf(animal);
            Animals.get(index).setName(name);
            Animals.get(index).setAge(age);
            Animals.get(index).setHealth(health_status);
            Animals.get(index).setFeeding(feeding_status);
            Animals.get(index).setGender(gender);
            Animals.get(index).setType(specific_type);
        }
    */

}
