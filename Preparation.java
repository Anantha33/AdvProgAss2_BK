package burritoking;

public class Preparation 
{
	//Variables related to burritos
	double numOfBurritosToBePrepared;
	double timeForBurritoPreparation;
	double burritosMaxPerBatch = 2;
	int timeForBurrito = 9;
	double totalTimeForBurritoPreparation;
	
	//Variables related to fries
	double numOfFriesToBePrepared;
	double timeForFriesPreparation;
	double friesMaxPerBatch = 5;
	int timeForFries = 8;
	double totalTimeForFriesPreparation;
	int numOfFriesRemainingAfterCurrentOrder = Data.friesLeft.get(0);
	
	//Variables related to meals
	double numOfMealsToBePrepared;
	double timeForMealPrep;
	double totalTimeForMealPrep;
	
	//Method for preparation of burritos
	public double burritoPreparation(int numOfBurritosOrdered)
	{
		Kitchen kitchen = new Kitchen();
		numOfBurritosOrdered += kitchen.getNumOfBurritosOrdered();
		System.out.println("Preparing burritos!");
		numOfBurritosToBePrepared = numOfBurritosOrdered;
		System.out.printf("%,.2f burritos prepared %n",numOfBurritosToBePrepared);
		
		//Calculating the time for Burrito preparation
		timeForBurritoPreparation = (Math.ceil(numOfBurritosToBePrepared/burritosMaxPerBatch) * timeForBurrito);
		System.out.printf("Time taken for burrito preparation: %,.2f minutes %n", timeForBurritoPreparation);
		totalTimeForBurritoPreparation += timeForBurritoPreparation;
		
		return numOfBurritosToBePrepared;
	}
	
	//Method for preparation of Fries
	public double friesPreparation(double numOfFriesOrdered)
	{
		Kitchen kitchen = new Kitchen();
		numOfFriesOrdered += kitchen.getNumOfFriesOrdered();
		
		if (numOfFriesOrdered > Data.friesLeft.get(0))
		{
			System.out.println("Preparing fries; please be patient");
			numOfFriesToBePrepared = Math.ceil(numOfFriesOrdered/friesMaxPerBatch);
			System.out.printf("%,.2f batch of fries prepared %n",numOfFriesToBePrepared);
			
			
			numOfFriesRemainingAfterCurrentOrder += (numOfFriesToBePrepared * friesMaxPerBatch) - numOfFriesOrdered;
			System.out.printf("%d serves of fries left for next order %n", numOfFriesRemainingAfterCurrentOrder);
			Data.friesLeft.set(0, numOfFriesRemainingAfterCurrentOrder);
			
			//Calculating the time for Fries Preparation
			timeForFriesPreparation = numOfFriesToBePrepared * timeForFries;
			System.out.printf("Time Taken for fries preparation: %,.2f minutes %n", timeForFriesPreparation);
			totalTimeForFriesPreparation += timeForFriesPreparation;
		}
		
		else if (numOfFriesOrdered <= Data.friesLeft.get(0))
		{
			numOfFriesRemainingAfterCurrentOrder -= numOfFriesOrdered;
			System.out.printf("%d serves of fries left for next order %n", numOfFriesRemainingAfterCurrentOrder);
			Data.friesLeft.set(0, numOfFriesRemainingAfterCurrentOrder);
		}
		return numOfFriesRemainingAfterCurrentOrder;
	}
	
	//Method for preparation of meals
	public double mealPrep(int numOfMeals)
	{
		int numOfBurritosInMeals = numOfMeals;
		int numOfFriesInMeals = numOfMeals;
		int numOfSodasInMeals = numOfMeals;
		
		double priceOfBurritosInMeals = numOfMeals * (Data.prices.get(0) - 1);
		double priceOfFriesInMeals = numOfMeals * (Data.prices.get(1) - 1);
		double priceOfSodasInMeals = numOfMeals * (Data.prices.get(2) - 1);
		
		System.out.println("Preparing burritos!");
		System.out.printf("%d burritos prepared %n", numOfBurritosInMeals);
		
		if (numOfFriesInMeals > Data.friesLeft.get(0))
		{
			System.out.println("Preparing fries; please be patient");
			numOfFriesToBePrepared = Math.ceil(numOfFriesInMeals/friesMaxPerBatch);
			System.out.printf("%,.2f batch of fries prepared %n",numOfFriesToBePrepared);
			
			
			numOfFriesRemainingAfterCurrentOrder += (numOfFriesToBePrepared * friesMaxPerBatch) - numOfFriesInMeals;
			System.out.printf("%d serves of fries left for next order %n", numOfFriesRemainingAfterCurrentOrder);
			Data.friesLeft.set(0, numOfFriesRemainingAfterCurrentOrder);
		}
		else if (numOfFriesInMeals <= Data.friesLeft.get(0))
		{
			numOfFriesRemainingAfterCurrentOrder -= numOfFriesInMeals;
			System.out.printf("%d serves of fries left for next order %n", numOfFriesRemainingAfterCurrentOrder);
			Data.friesLeft.set(0, numOfFriesRemainingAfterCurrentOrder);
		}
		
		double totalPriceOfMeals = priceOfBurritosInMeals + priceOfFriesInMeals + priceOfSodasInMeals;
		
		timeForMealPrep = (Math.ceil(numOfMeals/burritosMaxPerBatch) * timeForBurrito);
		System.out.printf("Time taken for meal preparation: %,.2f minutes %n", timeForMealPrep);
		totalTimeForMealPrep += timeForMealPrep;
		
		return totalPriceOfMeals;
	}
	
	//Returning the remaining number of fries
	public int getUnsoldFries()
	{
		return Data.friesLeft.get(0);
	}
	
	//Total time taken to process order
	public double getTimeForOrder()
	{
		if (totalTimeForMealPrep >= totalTimeForBurritoPreparation && totalTimeForMealPrep >= totalTimeForFriesPreparation)
		{
			return totalTimeForMealPrep;
		}
		else if (totalTimeForBurritoPreparation >= totalTimeForMealPrep && totalTimeForBurritoPreparation >= 
				totalTimeForFriesPreparation)
		{
			return totalTimeForBurritoPreparation;
		}
		else
		{
			return totalTimeForFriesPreparation;
		}
	}
}