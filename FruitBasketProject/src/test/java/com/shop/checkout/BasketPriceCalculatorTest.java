package com.shop.checkout;

import com.Fruit.inventory.ShoppingItem;
import com.Fruit.checkout.BasketPriceCalculator;
import com.Fruit.checkout.ShoppingBasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rajeev katare.
 * Tests BasketPriceCalculator functionality
 */
public class BasketPriceCalculatorTest {

    private BasketPriceCalculator basketPriceCal;

    @Before
    public void setUp() throws Exception {
    	basketPriceCal = new BasketPriceCalculator();

    }

    @Test
    public void getTotalPriceWithNoItems() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        double actual = basketPriceCal.getTotalPrice(basket);
        double expected = 0;
        assertTrue("Price should be 0",actual == expected );
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTotalPriceWithNullItems() throws Exception {
        double price = basketPriceCal.getTotalPrice(null);
    }

    @Test
    public void getTotalPriceWithOneItem1Quantity() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ShoppingItem item = new ShoppingItem("Banana",0.60);
        basket.addItem(item);

        double actual = basketPriceCal.getTotalPrice(basket);
        assertTrue("Price should be 0.60",actual==0.60 );
    }

    @Test
    public void getTotalPriceWithOneItemMultiQuanity() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ShoppingItem item1 = new ShoppingItem("Banana",0.70);
        ShoppingItem item2 = new ShoppingItem("Banana",0.70);
        ShoppingItem item3 = new ShoppingItem("Banana",0.70);
        ShoppingItem item4 = new ShoppingItem("Banana",0.70);
        
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);
        double expected = 2.80;
        double actual = basketPriceCal.getTotalPrice(basket);
        assertTrue("Price should be 2.80", actual == expected );
                
    }

    @Test
    public void getTotalPriceWithThreeItem1Quanityeach() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ShoppingItem item1 = new ShoppingItem("Banana",0.60);
        ShoppingItem item2 = new ShoppingItem("Apple",0.50);
        ShoppingItem item3 = new ShoppingItem("Orange",0.40);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);

        double actual = basketPriceCal.getTotalPrice(basket);
        double expected = 1.50;
        //banana -0.60, apple -0.50, orange - 0.40
        assertTrue("Price should be 1.50", actual == expected );

    }
    
    @Test
    public void getTotalPriceWithFiveItem1Quanityeach() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ShoppingItem item1 = new ShoppingItem("Banana",0.60);
        ShoppingItem item2 = new ShoppingItem("Apple",0.50);
        ShoppingItem item3 = new ShoppingItem("Orange",0.40);
        ShoppingItem item4 = new ShoppingItem("Lemon",0.70);
        ShoppingItem item5 = new ShoppingItem("Peach",0.80);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);
        basket.addItem(item5);

        double actual = basketPriceCal.getTotalPrice(basket);
        double expected = 3.0;
        //banana -0.60, apple -0.50, orange - 0.40
        assertTrue("Price should be 3.0", actual == expected );

    }

    @Test
    public void getTotalPriceWithMultiItemMultiQuanity() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ShoppingItem item1 = new ShoppingItem("Banana",0.60);
        ShoppingItem item2 = new ShoppingItem("Apple",0.50);
        ShoppingItem item3 = new ShoppingItem("Banana",0.60);
        ShoppingItem item4 = new ShoppingItem("Lemon",0.70);
        ShoppingItem item5 = new ShoppingItem("Apple",0.50);
        ShoppingItem item6 = new ShoppingItem("Orange",0.40);
        ShoppingItem item7 = new ShoppingItem("Lemon",0.70);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);
        basket.addItem(item5);
        basket.addItem(item6);
        basket.addItem(item7);

        double actual = basketPriceCal.getTotalPrice(basket);
        double expected = 4.0;
        //banana -0.60, apple -0.50, orange - 0.40

        assertTrue("Price should be 4.0", actual == expected);

    }
}