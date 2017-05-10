package com.Fruit.inventory;


/**
 * Shopping item class to store the Name and Price of the Fruit Item
 */
public class ShoppingItem {
    private String name;
    private double price;
  

    public ShoppingItem(String name,Double price){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Fruit Item name cann't be null or empty or number");
        }
        if(price == null || price < 0.0 ){
            throw new IllegalArgumentException("Fruit Item price cann't be null or less than 0.0");
        }
                     
        this.name = name.toUpperCase();
        this.price = price;
        
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
        
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingItem that = (ShoppingItem) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
