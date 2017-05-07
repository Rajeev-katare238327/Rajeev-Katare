package com.shop.checkout;

import com.Fruit.inventory.*;
import com.Fruit.checkout.ShoppingBasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rajeev katare.
 */
public class ShoppingBasketTest {

    private ShoppingBasket basket;
    @Before
    public void setUp() throws Exception {
        basket = new ShoppingBasket();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullItem() {
        basket.addItem(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void addItemWithEmptyName() {
        ShoppingItem item  = new ShoppingItem("",0.60);
        basket.addItem(item);

    }

    @Test
    public void clearsAllItemsFromTheBasket() {
        ShoppingItem item  = new ShoppingItem("Apple",0.60);
        basket.addItem(item);
        assertTrue(basket.getItems().size()>0);
        basket.clear();
        assertEquals("Basket must be empty",0,basket.getItems().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemWithNameAsBlankSpace() {
        ShoppingItem item  = new ShoppingItem(" ",0.60);
        basket.addItem(item);
    }

    @Test
    public void addOneItem() {
        ShoppingItem item  = new ShoppingItem("Apple",0.60);
        basket.addItem(item);

        assertEquals("Should have 1 item",1,basket.getItems().size());
    }

    @Test
    public void add2DifferentItems() {
        ShoppingItem item1  = new ShoppingItem("Apple",0.60);
        ShoppingItem item2  = new ShoppingItem("banana",0.40);
        basket.addItem(item1);
        basket.addItem(item2);

        assertEquals("Should have 1 item",2,basket.getItems().size());
    }

    @Test
    public void add2ItemsOfSameType() {
        ShoppingItem item1  = new ShoppingItem("Apple",0.60);
        ShoppingItem item2  = new ShoppingItem("Apple",0.60);
        basket.addItem(item1);
        basket.addItem(item2);

        assertEquals("Should have 1 item with qty as 2",1,basket.getItems().size());
        assertEquals("Should have 1 item with qty as 2",new Integer(2),basket.getItems().get(item1));
    }
}