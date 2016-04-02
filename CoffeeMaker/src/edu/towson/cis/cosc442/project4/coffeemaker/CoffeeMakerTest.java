package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	}

	//Successfully add recipe
	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	
	//Try to add a recipe that already exists
	public void testAddRecipe2() {
		cm.addRecipe(r1);
		assertFalse(cm.addRecipe(r1));
	}
	
	//Try to add a recipe to at max number of recipes
	public void testAddRecipe3() {
		Recipe r2, r3, r4, r5;
		
		r2 = new Recipe();
		r2.setName("Drink2");
		r2.setPrice(25);
		r2.setAmtCoffee(5);
		r2.setAmtMilk(4);
		r2.setAmtSugar(4);
		r2.setAmtChocolate(1);
		
		r3 = new Recipe();
		r3.setName("Drink3");
		r3.setPrice(50);
		r3.setAmtCoffee(0);
		r3.setAmtMilk(10);
		r3.setAmtSugar(0);
		r3.setAmtChocolate(0);
		
		r4 = new Recipe();
		r4.setName("Drink4");
		r4.setPrice(100);
		r4.setAmtCoffee(6);
		r4.setAmtMilk(4);
		r4.setAmtSugar(3);
		r4.setAmtChocolate(6);
		
		r5 = new Recipe();
		r5.setName("Drink5");
		r5.setPrice(75);
		r5.setAmtCoffee(6);
		r5.setAmtMilk(2);
		r5.setAmtSugar(2);
		r5.setAmtChocolate(0);
		
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		cm.addRecipe(r5);
		
		assertFalse(cm.addRecipe(r1));
	}

	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	//successfully add inventory
	public void testAddInventory1() {
		assertTrue(cm.addInventory(50, 20, 100, 25));
	}
	
	//try to add negative inventory
	public void testAddInventory2() {
		assertFalse(cm.addInventory(-50, 20, 100, 25));
	}
	
	public void testCheckInventory1() {
		cm.addInventory(50, 20, 100, 25);
		i = cm.checkInventory();
		assertEquals(50+15, i.getCoffee());
		assertEquals(20+15, i.getMilk());
		assertEquals(100+15, i.getSugar());
		assertEquals(25+15, i.getChocolate());
	}
	
	public void testPurchaseBeverage1() {
		cm.addRecipe(r1);
		cm.addInventory(50, 20, 100, 25);
		assertEquals(50, cm.makeCoffee(r1, 100));
	}
	
	//try to purchase beverage without the correct amount of money
	public void testPurchaseBeverage2() {
		cm.addRecipe(r1);
		cm.addInventory(50, 20, 100, 25);
		assertEquals(5, cm.makeCoffee(r1, 5));
	}
	
	//try to purchase beverage without enough coffee
	public void testPurchaseBeverage3() {
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 100);
		cm.makeCoffee(r1, 100);
		assertEquals(100, cm.makeCoffee(r1, 100));
	}
	
	//try to purchase beverage without enough milk
	public void testPurchaseBeverage4() {
		r1.setAmtMilk(15);
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 100);
		assertEquals(100, cm.makeCoffee(r1, 100));
	}
	
	//try to purchase beverage without enough sugar
	public void testPurchaseBeverage5() {
		r1.setAmtSugar(15);
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 100);
		assertEquals(100, cm.makeCoffee(r1, 100));
	}
	
	//try to purchase beverage without enough chocolate
	public void testPurchaseBeverage6() {
		r1.setAmtChocolate(15);
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 100);
		assertEquals(100, cm.makeCoffee(r1, 100));
	}
	
	//exact amount of inventory
	public void testPurchaseBeverage7() {
		r1.setAmtCoffee(15);
		r1.setAmtMilk(15);
		r1.setAmtSugar(15);
		r1.setAmtChocolate(15);
		cm.addRecipe(r1);
		assertEquals(50, cm.makeCoffee(r1, 100));
	}
	
	//get recipe given name
	public void testGetRecipe() {
		cm.addRecipe(r1);
		assertEquals(r1, cm.getRecipeForName("Coffee"));
	}
}