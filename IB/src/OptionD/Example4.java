package OptionD;

import java.util.ArrayList;

public class Example4 {
    public static void main(String[] args) {

        //Polymorphism with data structures
        ArrayList<Item> inventory = new ArrayList<>();
        Item apple = new Item();
        Item armor = new Item();
        Weapon sword = new Weapon();

        inventory.add(apple);
        inventory.add(armor);
        inventory.add(sword); // Weapon can be added because it is Ite, too
    }
}

class Item{
    void display() {
        System.out.println("Display item");
    }
}

class Weapon extends Item {
    int damage = 100;
    void display(){
        System.out.println("Display weapon");
    }
}
