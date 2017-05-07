package com.Fruit.checkout;

import com.Fruit.inventory.ShoppingItem;
import java.util.HashMap;


/**
 * Class to manage the shopping items
 */
public class ShoppingBasket {

    // map of Fruit items to their quantity
    private HashMap<ShoppingItem, Integer> fruitsBasket;
    
    public HashMap<ShoppingItem, Integer> getItems() {
        return fruitsBasket;
    }

    public ShoppingBasket(){
    	fruitsBasket = new HashMap<>();
    }


    /**
     * Adds an item with a initial quantity of 1. if the item already exists, its quantity will be increase by 1
     * @param item shoppingItem to be added
     */
    public void addItem(ShoppingItem theItem){
        if(theItem == null){
            throw new IllegalArgumentException("Shopping item can not be null");
        }
             
		 if (fruitsBasket.containsKey(theItem)) {
			 fruitsBasket.put(theItem, fruitsBasket.get(theItem) + 1);
		        } else {
		        	fruitsBasket.put(theItem, 1);
		        }
		 
    }

    /**
     * Clears all items in the shopping basket
     */
    public void clear(){
    	fruitsBasket.clear();
    }

}
