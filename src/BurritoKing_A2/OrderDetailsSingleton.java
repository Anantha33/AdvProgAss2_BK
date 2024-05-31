package BurritoKing_A2;

public class OrderDetailsSingleton 
{
	private static OrderDetailsSingleton single_instance = null;
	
	private int currentNumOfBurritos;
	private int currentNumOfFries;
	private int currentNumOfSodas;
	private int currentNumOfMeals;
	private double currentNumOfFriesLeft = 0;
	private double currentTotalCost;
	private double currentPrepTime;
	//private double currentOrderCredits = 0;
	
	public void setCurrentOrderDetails(int numOfBurritos, int numOfFries, int numOfSodas, int numOfMeals, double numOfFriesLeft,
			double totalOrderCost, double prepTime)
	{
		currentNumOfBurritos = numOfBurritos;
		currentNumOfFries = numOfFries;
		currentNumOfSodas = numOfSodas;
		currentNumOfMeals = numOfMeals;
		currentNumOfFriesLeft = numOfFriesLeft;
		currentTotalCost = totalOrderCost;
		currentPrepTime = prepTime;
		//currentOrderCredits = credits;
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
	
	public double getCurrentNumOfFriesLeft()
	{
		return currentNumOfFriesLeft;
	}
	
	public double getCurrentTotalCost()
	{
		return currentTotalCost;
	}
	
	public double getCurrentPrepTime()
	{
		return currentPrepTime;
	}
	
	/*public double getCurrentOrderCredits()
	{
		return currentOrderCredits;
	}*/
	
	public static synchronized OrderDetailsSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new OrderDetailsSingleton();
 
        return single_instance;
    }
}