package burritoking;
import java.util.*;

public class Data 
{
	//An arraylist for the prices of burrito, fries, and soda respectively
	public static ArrayList <Double> prices = new ArrayList<Double>(); 
	static
	{
		prices.add(7.0);
		prices.add(4.0);
		prices.add(2.5);
	}
	
	//An arraylist for storing the number of fries left after each order
	public static ArrayList <Integer> friesLeft = new ArrayList<Integer>();
	static
	{
		friesLeft.add(0);
	}
	
	//An arraylist for storing the total number of burritos sold
	public static ArrayList <Integer> totalBurritos = new ArrayList<Integer>();
	static
	{	
		totalBurritos.add(0);
	}
	
	//An arraylist for storing the total sales of burritos
	public static ArrayList <Double> totalSalesBurrito = new ArrayList<Double>();
	static
	{	
		totalSalesBurrito.add(0.0);
	}
	
	//An arraylist for storing the total number of fries sold
	public static ArrayList <Integer> totalFries = new ArrayList<Integer>();
	static
	{	
		totalFries.add(0);
	}
	
	//An arraylist for storing the total sales of fries
	public static ArrayList <Double> totalSalesFries = new ArrayList<Double>();
	static
	{	
		totalSalesFries.add(0.0);
	}
	
	//An arraylist for storing the total number of sodas sold
	public static ArrayList <Integer> totalSodas = new ArrayList<Integer>();
	static
	{	
		totalSodas.add(0);
	}
	
	//An arraylist for storing the total sales of sodas
	public static ArrayList <Double> totalSalesSoda = new ArrayList<Double>();
	static
	{	
		totalSalesSoda.add(0.0);
	}
	
	//An arraylist for storing the total number of meals sold
	public static ArrayList <Integer> totalMeals = new ArrayList<Integer>();
	static
	{	
		totalMeals.add(0);
	}
	
	//An arraylist for storing the total sales of meals
	public static ArrayList <Double> totalSalesMeals = new ArrayList<Double>();
	static
	{	
		totalSalesMeals.add(0.0);
	}
}
