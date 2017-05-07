package com.shop.inventory;

import org.junit.Test;

import com.Fruit.inventory.ShoppingItem;

import static org.junit.Assert.*;

/**
 * Created by Rajeev katare.
 */
public class ShoppingItemTest {

	@Test(expected = IllegalArgumentException.class)
	public void createItemWithNullNameAndPrice() {
		ShoppingItem item = new ShoppingItem(null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createItemWithNullNameAndValidPrice() {
		ShoppingItem item = new ShoppingItem(null, 0.10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createItemWithValidNameAndNullPrice() {
		ShoppingItem item = new ShoppingItem("Test", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createItemWithEmptyNameAndValidPrice() {
		ShoppingItem item = new ShoppingItem("", 0.10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createItemWithBlankSpaceNameAndPrice() {
		ShoppingItem item = new ShoppingItem(" ", 0.10);
	}

	@Test
	public void testEquals() throws Exception {
		ShoppingItem item1 = new ShoppingItem("Apple", 0.10);
		ShoppingItem item2 = new ShoppingItem("Apple", 0.10);
		ShoppingItem item3 = new ShoppingItem("apple", 0.10);

		assertEquals("Items should be equal", item1, item2);
		assertEquals("Items should be equal", item3, item2);
	}

	@Test
	public void testHashCode() throws Exception {
		ShoppingItem item1 = new ShoppingItem("Apple", 0.10);
		ShoppingItem item2 = new ShoppingItem("Apple", 0.10);
		ShoppingItem item3 = new ShoppingItem("apple", 0.10);

		assertEquals("Items should be equal", item1.hashCode(),
				item2.hashCode());
		assertEquals("Items should be equal", item3.hashCode(),
				item2.hashCode());
	}

}