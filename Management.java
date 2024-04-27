package burritoking;
import java.util.Scanner;

//Management class
public class Management 
{
	Kitchen kitchen = new Kitchen();
	
	//Method for sales report calculation and display
	public void salesReport(int totalNumOfBurritosSold, double totalSalesOfBurrito, int totalNumOfFriesSold, double totalSalesOfFries, 
			int totalNumOfSodasSold, double totalSalesOfSoda, int totalNumOfMealsSold, double totalSalesOfMeals, int unsoldFries)
	{
		double totalSalesPriceOfBurrito = totalSalesOfBurrito;
		double totalSalesPriceOfFries = totalSalesOfFries;
		double totalSalesPriceOfSodas = totalSalesOfSoda;
		double totalSalesPriceOfMeals = totalSalesOfMeals;
		
		int totalUnsoldFries = unsoldFries;
		
		int totalNumOfItemsSold = totalNumOfBurritosSold + totalNumOfFriesSold + totalNumOfSodasSold + totalNumOfMealsSold;
		
		double totalSalesPriceOfAllItems = totalSalesPriceOfBurrito + totalSalesPriceOfFries + totalSalesPriceOfSodas + 
				totalSalesPriceOfMeals;
		
		System.out.printf("Unsold serves of fries: %d %n", totalUnsoldFries); 
		System.out.printf("Total Sales: %n");
		System.out.printf("Burritos: %d $%,.2f %n", totalNumOfBurritosSold, totalSalesPriceOfBurrito);
		System.out.printf("Fries: %4d $%,.2f %n", totalNumOfFriesSold, totalSalesPriceOfFries);
		System.out.printf("Sodas: %4d $%,.2f %n", totalNumOfSodasSold, totalSalesPriceOfSodas);
		System.out.printf("Meals: %4d $%,.2f %n", totalNumOfMealsSold, totalSalesPriceOfMeals);
		System.out.printf("--------------------------- %n");
		System.out.printf("%11d $%,.2f %n", totalNumOfItemsSold, totalSalesPriceOfAllItems);
	}
	
	
	
	//Method to accurately process transactions
	public void transaction(double totalPrice)
	{
		System.out.printf("Please enter money: %n");
		try
		{
			Scanner moneyInput = new Scanner(System.in);
			double moneyPaid = moneyInput.nextDouble();
			
			if (moneyPaid < 0)
			{
				System.out.printf("Invalid Input! Please try again %n");
				transaction(totalPrice);
			}
			else
			{
				if (moneyPaid < totalPrice)
				{
					System.out.printf("Sorry, that's not enough to pay for order %n");
					transaction(totalPrice);
				}
				
				else if (moneyPaid > totalPrice)
				{
					System.out.printf("Change returned: $%,.2f %n", (moneyPaid - totalPrice));
				}
				
				else
				{
					System.out.printf("You have given exact change! Thank you. %n");
					System.out.printf("Change returned: $%,.2f %n", (moneyPaid - totalPrice));
				}
			}
		}
		catch (Exception e) //Exception handling
		{
			System.out.printf("Invalid Input! Please try again %n");
			transaction(totalPrice);
		}
		
	}
}