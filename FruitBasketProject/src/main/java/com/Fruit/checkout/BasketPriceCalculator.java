package com.Fruit.checkout;

import java.util.Map;

import com.Fruit.inventory.*;

/**
 * Implements Fruit check out functionality for the basket
 */
public class BasketPriceCalculator {

    /**
     * Calculates the total price for the basket containing shopping Fruit items
     * @param basket - Shopping basket containing the items to check out
     * @return double representation of the total cost price for the basket
     */
    public double getTotalPrice(ShoppingBasket basket){
        double basketPrice = 0.0;
    	if(basket == null){
            throw new IllegalArgumentException("Shopping basket can not be null");
        }
    	final Map<ShoppingItem,Integer> items = basket.getItems();
        for (ShoppingItem fruit : items.keySet()) {
			basketPrice = basketPrice + ( fruit.getPrice() * items.get(fruit));
			System.out.print("\n Fruit Name: " + fruit.getName()
					+ "  Total units: " + items.get(fruit) + "  Price per unit: " + fruit.getPrice());
		}
        System.out.print("\n Complete basket price for all the Fruit items entered is : "+ basketPrice);
		return basketPrice;

    }

}
