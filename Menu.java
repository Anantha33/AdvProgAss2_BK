//J-UNIT TESTS

package burritoking;
import java.util.*;

//Main menu class
public class Menu 
{	
	//Variables related to burritos
	int totalNumOfBurritosSoldCurrentOrder;
	int totalNumOfBurritosSoldPrevOrders;
	int totalNumOfBurritosSold;
	
	double totalSalesBurritoCurrentOrder;
	double totalSalesBurritoPrevOrders;
	double totalSalesBurrito;
	
	//Variables related to fries
	int totalNumOfFriesSoldCurrentOrder;
	int totalNumOfFriesSoldPrevOrders;
	int totalNumOfFriesSold;
	
	double totalSalesFriesCurrentOrder;
	double totalSalesFriesPrevOrders;
	double totalSalesFries;
	
	//Variables related to sodas
	int totalNumOfSodasSoldCurrentOrder;
	int totalNumOfSodasSoldPrevOrders;
	int totalNumOfSodasSold;
	
	double totalSalesSodasCurrentOrder;
	double totalSalesSodasPrevOrders;
	double totalSalesSodas;
	
	//Variables related to meals
	int totalNumOfMealsSoldCurrentOrder;
	int totalNumOfMealsSoldPrevOrders;
	int totalNumOfMealsSold;
	
	double totalSalesMealsCurrentOrder;
	double totalSalesMealsPrevOrders;
	double totalSalesMeals;
	
	
	int unsoldFries;
	
	public void displayMenu()
	{
		Kitchen kitchen = new Kitchen();
		Preparation prepare = new Preparation();
		Management manage = new Management();
		Update update = new Update();
	
		
		System.out.printf("========================= %n");
		System.out.printf("Burrito King %n");
		System.out.printf("========================= %n");
		System.out.printf("a) Order %n");
		System.out.printf("b) Show sales report %n");
		System.out.printf("c) Update prices %n");
		System.out.printf("d) Exit %n");
		System.out.printf("Please select: %n");
		
		Scanner input = new Scanner(System.in);
		String userOption = input.next();
		
		switch (userOption)
		{
			case "a": //Order case
				kitchen.Order();
				
				//Appending the necessary variables after each order
				totalNumOfBurritosSoldCurrentOrder = kitchen.getNumOfBurritosSold();
				totalNumOfBurritosSoldPrevOrders = Data.totalBurritos.get(0);
				Data.totalBurritos.set(0, totalNumOfBurritosSoldPrevOrders + totalNumOfBurritosSoldCurrentOrder);
				totalNumOfBurritosSold = Data.totalBurritos.get(0);
				
				totalNumOfFriesSoldCurrentOrder = kitchen.getNumOfFriesSold();
				totalNumOfFriesSoldPrevOrders = Data.totalFries.get(0);
				Data.totalFries.set(0, totalNumOfFriesSoldPrevOrders + totalNumOfFriesSoldCurrentOrder);
				totalNumOfFriesSold = Data.totalFries.get(0);
				
				totalNumOfSodasSoldCurrentOrder = kitchen.getNumOfSodasSold();
				totalNumOfSodasSoldPrevOrders = Data.totalSodas.get(0);
				Data.totalSodas.set(0, totalNumOfSodasSoldPrevOrders + totalNumOfSodasSoldCurrentOrder);
				totalNumOfSodasSold = Data.totalSodas.get(0);
				
				totalNumOfMealsSoldCurrentOrder = kitchen.getNumOfMealsSold();
				totalNumOfMealsSoldPrevOrders = Data.totalMeals.get(0);
				Data.totalMeals.set(0, totalNumOfMealsSoldPrevOrders + totalNumOfMealsSoldCurrentOrder);
				totalNumOfMealsSold = Data.totalMeals.get(0);
				
				totalSalesBurritoCurrentOrder = kitchen.getTotalSalesBurritoCurrentOrder();
				totalSalesBurritoPrevOrders = Data.totalSalesBurrito.get(0);
				Data.totalSalesBurrito.set(0, totalSalesBurritoPrevOrders + totalSalesBurritoCurrentOrder);
				totalSalesBurrito = Data.totalSalesBurrito.get(0);
				
				totalSalesFriesCurrentOrder = kitchen.getTotalSalesFriesCurrentOrder();
				totalSalesFriesPrevOrders = Data.totalSalesFries.get(0);
				Data.totalSalesFries.set(0, totalSalesFriesPrevOrders + totalSalesFriesCurrentOrder);
				totalSalesFries = Data.totalSalesFries.get(0);
				
				totalSalesSodasCurrentOrder = kitchen.getTotalSalesSodasCurrentOrder();
				totalSalesSodasPrevOrders = Data.totalSalesSoda.get(0);
				Data.totalSalesSoda.set(0, totalSalesSodasPrevOrders + totalSalesSodasCurrentOrder);
				totalSalesSodas = Data.totalSalesSoda.get(0);
				
				totalSalesMealsCurrentOrder = kitchen.getTotalSalesMealsCurrentOrder();
				totalSalesMealsPrevOrders = Data.totalSalesMeals.get(0);
				Data.totalSalesMeals.set(0, totalSalesMealsPrevOrders + totalSalesMealsCurrentOrder);
				totalSalesMeals = Data.totalSalesMeals.get(0);
				
				unsoldFries = prepare.getUnsoldFries(); //Retrieving the number of remaining/unsold fries
				
				displayMenu();
				break;
				
			case "b": //Calculating and displaying the sales report
				manage.salesReport(totalNumOfBurritosSold, totalSalesBurrito, totalNumOfFriesSold, totalSalesFries, 
						totalNumOfSodasSold, totalSalesSodas, totalNumOfMealsSold, totalSalesMeals, unsoldFries);
				displayMenu();
				break;
				
			case "c": //Update prices section
				update.updatePrices();
				displayMenu();
				break;
				
			case "d": //Exiting the program
				System.out.printf("Thank you for your time! See you later %n");
				break;
				
			default: //Also handles exceptions
				System.out.printf("Invalid Input! Please try again %n");
				displayMenu();
		}
	}
}