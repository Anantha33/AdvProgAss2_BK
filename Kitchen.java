package burritoking;
import java.util.*;


public class Kitchen 
{
	Preparation prepare = new Preparation();
	
	//Initializing variables for all the items sold
	int numOfBurritosSold;
	int numOfFriesSold;
	int numOfSodasSold;
	int numOfMealsSold;
	
	//Initializing variables for all the items ordered
	int numOfBurritosOrdered;
	double numOfFriesOrdered;
	int numOfSodasOrdered;
	int numOfMealsOrdered;
	
	double mealSales;
	double totalPrice;
	
	//Order method
	public void Order()
	{	
		Management manage = new Management();
		
		System.out.printf("> Select the food item: %n");
		System.out.printf("1. Burrito ($%,.2f per burrito) %n", Data.prices.get(0));
		System.out.printf("2. Fries ($%,.2f per serve of fries) %n", Data.prices.get(1));
		System.out.printf("3. Soda ($%,.2f per soda) %n", Data.prices.get(2));
		System.out.printf("4. Meal ($%,.2f per meal) %n",((Data.prices.get(0) - 1) + (Data.prices.get(1) - 1) + (Data.prices.get(2) - 1)));
		System.out.printf("5. No more %n");
		System.out.printf("Please select: %n");
		
		try
		{
			Scanner input = new Scanner(System.in);
			int userInput = input.nextInt();
			
			switch(userInput)
			{
				case 1: //Processing of burritos
					System.out.printf("How many burritos would you like to buy?: %n");
					
					Scanner serveOfBurritos = new Scanner(System.in);
					numOfBurritosOrdered = serveOfBurritos.nextInt();
					
					if (numOfBurritosOrdered < 0) //Checking if the input is positive
					{
						System.out.printf("Invalid Input! Please try again %n");
						Order();
					}
					else
					{
						double numOfBurritosPrepared = prepare.burritoPreparation(numOfBurritosOrdered);
						numOfBurritosSold += numOfBurritosPrepared;
						Order();
					}
					break;
					
				case 2: //Processing of fries
					System.out.printf("How many serves of fries would you like to buy?: %n");
					
					Scanner serveOfFries = new Scanner(System.in);
					numOfFriesOrdered = serveOfFries.nextInt();
					
					if (numOfFriesOrdered < 0) //Checking if the input is positive
					{
						System.out.printf("Invalid Input! Please try again %n");
						Order();
					}
					else
					{
						prepare.friesPreparation(numOfFriesOrdered);
						numOfFriesSold += numOfFriesOrdered;
						Order();
					}
					break;
					
				case 3: //Processing of sodas
					System.out.printf("How many sodas would you like to buy?: %n");
					
					Scanner serveOfSodas = new Scanner(System.in);
					numOfSodasOrdered = serveOfSodas.nextInt();
					
					if (numOfSodasOrdered < 0) //Checking if the input is positive
					{
						System.out.printf("Invalid Input! Please try again %n");
						Order();
					}
					else
					{
						numOfSodasSold += numOfSodasOrdered;
						Order();
					}
					break;
					
				case 4: //Processing of meals
					System.out.printf("How many meals would you like to buy?: %n");
					Scanner numOfMeals = new Scanner(System.in);
					numOfMealsOrdered = numOfMeals.nextInt();
					
					if (numOfMealsOrdered < 0) //Checking if the input is positive
					{
						System.out.printf("Invalid Input! Please try again %n");
						Order();
					}
					else
					{
						mealSales += prepare.mealPrep(numOfMealsOrdered);
						numOfMealsSold += numOfMealsOrdered;
						Order();
					}
					break;
					
				case 5: //Completing the current order
					totalPrice = ((numOfBurritosSold * Data.prices.get(0)) + (numOfFriesSold * Data.prices.get(1)) + 
							(numOfSodasSold * Data.prices.get(2)) + mealSales);
					System.out.printf("Total for %d Burritos, %d Fries, %d Sodas, and %d Meals is $%,.2f %n", numOfBurritosSold, 
							numOfFriesSold, numOfSodasSold, numOfMealsSold,totalPrice);
					
					manage.transaction(totalPrice);
					System.out.printf("Time taken: %,.2f minutes %n", prepare.getTimeForOrder());
					break;
					
				default:
					System.out.printf("Invalid Input! Please try again %n");
					Order();
			}
		}
		catch (Exception e) //Exception handling
		{
			System.out.printf("Invalid Input! Please try again %n");
			Order();
		}
	}
	
	
	//Getter methods
	public int getNumOfBurritosOrdered()
	{
		return numOfBurritosOrdered;
	}
	
	public double getNumOfFriesOrdered()
	{
		return numOfFriesOrdered;
	}
	
	public int getNumOfBurritosSold() 
	{
        return numOfBurritosSold; // Getter method to retrieve the total number of burritos sold
    }
	
	public int getNumOfFriesSold()
	{
		return numOfFriesSold; // Getter method to retrieve the total number of fries sold
	}
	
	public int getNumOfSodasSold()
	{
		return numOfSodasSold; // Getter method to retrieve the total number of sodas sold
	}
	
	public int getNumOfMealsSold()
	{
		return numOfMealsSold;
	}
	
	public double getTotalSalesBurritoCurrentOrder()
	{
		return numOfBurritosSold * Data.prices.get(0); //Getter method to return the total burrito sales for current order
	}
	
	public double getTotalSalesFriesCurrentOrder()
	{
		return numOfFriesSold * Data.prices.get(1); //Getter method to return the total fries sales for current order
	}
	
	public double getTotalSalesSodasCurrentOrder()
	{
		return numOfSodasSold * Data.prices.get(2); //Getter method to return the total sodas sales for current order
	}
	
	public double getTotalSalesMealsCurrentOrder()
	{
		return mealSales; //Getter method to return the total meals sales for current order
	}
}