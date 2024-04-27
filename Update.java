package burritoking;
import java.util.*;

//Class dedicated to the update prices section
public class Update 
{	
	double newPriceForBurrito;
	double newPriceForFries;
	double newPriceForSoda;
	
	public void updatePrices()
	{		
		Menu menu = new Menu();
		
		System.out.printf("========================= %n");
		System.out.printf("Update Prices %n");
		System.out.printf("========================= %n");
		System.out.printf("1. Burrito %n");
		System.out.printf("2. Fries %n");
		System.out.printf("3. Soda %n");
		System.out.printf("4. Show current price of items %n");
		System.out.printf("5. Exit %n");
		System.out.printf("Please enter item number (eg. 1 for Burrito, and so on): %n");
		
		try 
		{
				Scanner input = new Scanner(System.in);
				int itemNumber = input.nextInt();
				switch(itemNumber)
				{
					case 1: //Burrito Price Updation
						System.out.printf("Enter the new price for one burrito: %n");
						Scanner burritoPrice = new Scanner(System.in);
						newPriceForBurrito = burritoPrice.nextDouble();
						
						if (newPriceForBurrito < 0) //Checking if the input is positive
						{
							System.out.printf("Invalid Input! Please try again %n");
							updatePrices();
						}
						else
						{
							Data.prices.set(0, newPriceForBurrito); //0 being the index for burrito price in Data.prices
							System.out.printf("Price for one burrito updated successfully! %n");
							System.out.printf("Updated Price: $%,.2f %n", newPriceForBurrito);
							updatePrices();
						}
						break;
						
					case 2: //Fries Price Updation
						System.out.printf("Enter the new price for one serve of fries: %n");
						Scanner friesPrice = new Scanner(System.in);
						newPriceForFries = friesPrice.nextDouble();
						
						if (newPriceForFries < 0) //Checking if the input is positive
						{
							System.out.printf("Invalid Input! Please try again %n");
							updatePrices();
						}
						else
						{
							Data.prices.set(1, newPriceForFries); //1 being the index for fries price in Data.prices
							System.out.printf("Price for one serve of fries updated successfully! %n");
							System.out.printf("Updated Price: $%,.2f %n", newPriceForFries);
							updatePrices();
						}
						break;
					
					case 3: //Soda Price Updation
						System.out.printf("Enter the new price for one soda: %n");
						Scanner sodaPrice = new Scanner(System.in);
						newPriceForSoda = sodaPrice.nextDouble();
						
						if (newPriceForSoda < 0) //Checking if the input is positive
						{
							System.out.printf("Invalid Input! Please try again %n");
							updatePrices();
						}
						else
						{
							Data.prices.set(2, newPriceForSoda); //2 being the index for soda price in Data.prices
							System.out.printf("Price for one soda updated successfully! %n");
							System.out.printf("Updated Price: $%,.2f %n", newPriceForSoda);
							updatePrices();
						}
						break;
						
					case 4: //Displaying all the current food item prices
						System.out.printf("Price of one Burrito: $%,.2f %n", Data.prices.get(0));
						System.out.printf("Price of one serve of Fries: $%,.2f %n", Data.prices.get(1));
						System.out.printf("Price of one Soda: $%,.2f %n", Data.prices.get(2));
						updatePrices();
						break;
						
					case 5: //Exiting out of the update prices section
						break;
						
					default:
						System.out.printf("Invalid Input! Please try again %n");
						updatePrices();
				}
		}
		catch (Exception e) //Exception handling
		{
			System.out.printf("Invalid Input! Please try again %n");
			updatePrices();
		}
		
	}
	
}
