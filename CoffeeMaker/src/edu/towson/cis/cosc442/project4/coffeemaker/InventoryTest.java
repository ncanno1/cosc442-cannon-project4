package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	private Inventory i;
	
	@Before
	public void setUp() throws Exception {
		i = new Inventory();
	}

	@Test
	public void testSetCoffeeNegative() {
		i.setCoffee(-1);
		assertEquals(0, i.getCoffee());
	}
	
	@Test
	public void testSetMilkNegative() {
		i.setMilk(-1);
		assertEquals(0, i.getMilk());
	}
	
	@Test
	public void testSetSugarNegative() {
		i.setSugar(-1);
		assertEquals(0, i.getSugar());
	}
	
	@Test
	public void testSetChocolateNegative() {
		i.setChocolate(-1);
		assertEquals(0, i.getChocolate());
	}
	
	@Test
	public void testToString() {
		i.setCoffee(5);
		i.setMilk(4);
		i.setSugar(4);
		i.setChocolate(0);
		assertEquals("Coffee: 5\nMilk: 4\nSugar: 4\nChocolate: 0\n", i.toString());
	}

}
