package burritoking;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void testFriesPreparation() 
	{
        Preparation prepare = new Preparation();
        double result = prepare.friesPreparation(6); // Prepare 8 servings of fries
        
        // Assert that the correct number of fries are prepared and the rest are left for next order
        assertEquals(4, result, 0.01); //Here, 4 indicates the number of fries left
    }
	
	@org.junit.Test
	public void testBurritoPreparation() 
	{
        Preparation prepare = new Preparation();
        double result = prepare.burritoPreparation(6); // Prepare 6 burritos
        
        // Assert that the correct number of burritos are prepared
        assertEquals(6, result, 0.01);
    }
	
	@org.junit.Test
	public void testUpdatePrices() 
	{
        Update update = new Update();
        update.updatePrices(); // Update price of burrito to $6
        
        // Assert that the price of burrito is updated successfully
        assertEquals(6, update.newPriceForBurrito, 0.01);
    }
	
	@org.junit.Test
	public void testNumOfBurritosSold() 
	{
        Kitchen kitchen = new Kitchen();
        kitchen.Order();
        assertTrue(kitchen.getNumOfBurritosSold() >= 0);
    }
	
	@org.junit.Test
    public void testNumOfSodasSoldInitially() 
	{
        Kitchen kitchen = new Kitchen();
        assertFalse(kitchen.getNumOfSodasSold() != 0);
    }
	
	@org.junit.Test
	public void testUnsoldFries() 
	{
        Preparation prepare = new Preparation();
        assertTrue(prepare.getUnsoldFries() >= 0);
    }
}
