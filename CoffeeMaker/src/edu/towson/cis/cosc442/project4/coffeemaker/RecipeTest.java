package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipeTest {
	private Recipe r1;

	@Before
	public void setUp() throws Exception {
		r1 = new Recipe();
	}

	@Test
	public void testSetPriceNegative() {
		r1.setPrice(-1);
		assertEquals(0, r1.getPrice());
	}
	
	@Test
	public void testSetAmtCoffeeNegative() {
		r1.setAmtCoffee(-1);
		assertEquals(0, r1.getAmtCoffee());
	}
	
	@Test
	public void testSetAmtMilkNegative() {
		r1.setAmtMilk(-1);
		assertEquals(0, r1.getAmtMilk());
	}
	
	@Test
	public void testSetAmtSugarNegative() {
		r1.setAmtSugar(-1);
		assertEquals(0, r1.getAmtSugar());
	}
	
	@Test
	public void testSetAmtChocolateNegative() {
		r1.setAmtChocolate(-1);
		assertEquals(0, r1.getAmtChocolate());
	}

}
