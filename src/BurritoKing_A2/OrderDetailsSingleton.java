package BurritoKing_A2;

public class OrderDetailsSingleton 
{
	private static OrderDetailsSingleton single_instance = null;
	
	private int currentNumOfBurritos;
	private int currentNumOfFries;
	private int currentNumOfSodas;
	private int currentNumOfMeals;
	private int currentNumOfFriesLeft;
	private double currentTotalCost;
	
	public void setCurrentOrderDetails(int numOfBurritos, int numOfFries, int numOfSodas, int numOfMeals, double totalOrderCost, 
			int numOfFriesLeft)
	{
		currentNumOfBurritos = numOfBurritos;
		currentNumOfFries = numOfFries;
		currentNumOfSodas = numOfSodas;
		currentNumOfMeals = numOfMeals;
		currentNumOfFriesLeft = numOfFriesLeft;
		currentTotalCost = totalOrderCost;
	}
	
	public int getCurrentNumOfBurritos()
	{
		return currentNumOfBurritos;
	}
	
	public int getCurrentNumOfFries()
	{
		return currentNumOfFries;
	}
	
	public int getCurrentNumOfSodas()
	{
		return currentNumOfSodas;
	}
	
	public int getCurrentNumOfMeals()
	{
		return currentNumOfMeals;
	}
	
	public int getCurrentNumOfFriesLeft()
	{
		return currentNumOfFriesLeft;
	}
	
	public double getCurrentTotalCost()
	{
		return currentTotalCost;
	}
	
	public static synchronized OrderDetailsSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new OrderDetailsSingleton();
 
        return single_instance;
    }
}