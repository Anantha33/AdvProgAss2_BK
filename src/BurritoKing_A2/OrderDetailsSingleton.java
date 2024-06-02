package BurritoKing_A2;


//Singleton class to handle all the necessary order items, total cost and preparation time
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
	
	//Setter method to set attributes
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
	}
	
	
	//Getter methods for all attributes
	
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
	
	//Checking if the class has only one instance
	public static synchronized OrderDetailsSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new OrderDetailsSingleton();
 
        return single_instance;
    }
}