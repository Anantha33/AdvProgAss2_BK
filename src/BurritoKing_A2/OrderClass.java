package BurritoKing_A2;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//This class handles all the things related to the displaying of order items
public class OrderClass 
{
	private IntegerProperty orderIDProperty;
	
	private IntegerProperty orderNumOfBurritosProperty;
	private IntegerProperty orderNumOfFriesProperty;
	private IntegerProperty orderNumOfSodasProperty;
	private IntegerProperty orderNumOfMealsProperty;
	private StringProperty orderAllItemsProperty;
	
	private StringProperty orderDateProperty;
	private StringProperty orderTimeProperty;
	
	private DoubleProperty orderTotalCostProperty;
	private StringProperty orderStatusProperty;
	
	public OrderClass()
	{
		this.orderIDProperty = new SimpleIntegerProperty();
		
		this.orderNumOfBurritosProperty = new SimpleIntegerProperty();
		this.orderNumOfFriesProperty = new SimpleIntegerProperty();
		this.orderNumOfSodasProperty = new SimpleIntegerProperty();
		this.orderNumOfMealsProperty = new SimpleIntegerProperty();
		this.orderDateProperty = new SimpleStringProperty();
		this.orderTimeProperty = new SimpleStringProperty();
		this.orderTotalCostProperty = new SimpleDoubleProperty();
		this.orderStatusProperty = new SimpleStringProperty();
	}
	
	
	//This is for order ID
	public int getID()
	{
		return orderIDProperty.get();
	}
	
	public void setOrderID(int orderID)
	{
		this.orderIDProperty.set(orderID);
	}
	
	public IntegerProperty getOrderID()
	{
		return orderIDProperty;
	}
	
	//This is for number of burritos
	public int getNumOfBurritos()
	{
		return orderNumOfBurritosProperty.get();
	}
	
	public void setOrderNumOfBurritos(int orderNumOfBurritos)
	{
		this.orderNumOfBurritosProperty.set(orderNumOfBurritos);
	}
	
	public IntegerProperty getOrderNumOfBurritos()
	{
		return orderNumOfBurritosProperty;
	}
	
	
	//This is for number of fries
	public int getNumOfFries()
	{
		return orderNumOfFriesProperty.get();
	}
	
	public void setOrderNumOfFries(int orderNumOfFries)
	{
		this.orderNumOfFriesProperty.set(orderNumOfFries);
	}
	
	public IntegerProperty getOrderNumOfFries()
	{
		return orderNumOfFriesProperty;
	}
	
	
	//This is for number of sodas
	public int getNumOfSodas()
	{
		return orderNumOfSodasProperty.get();
	}
	
	public void setOrderNumOfSodas(int orderNumOfSodas)
	{
		this.orderNumOfSodasProperty.set(orderNumOfSodas);
	}
	
	public IntegerProperty getOrderNumOfSodas()
	{
		return orderNumOfSodasProperty;
	}
	
	
	//This is for number of meals
	public int getNumOfMeals()
	{
		return orderNumOfMealsProperty.get();
	}
	
	public void setOrderNumOfMeals(int orderNumOfMeals)
	{
		this.orderNumOfMealsProperty.set(orderNumOfMeals);
	}
	
	public IntegerProperty getOrderNumOfMeals()
	{
		return orderNumOfMealsProperty;
	}
	
	
	//This is for all order items
	public void setOrderAllItems()
	{
		String numOfBurritos = String.valueOf(getNumOfBurritos());
		String numOfFries = String.valueOf(getNumOfFries());
		String numOfSodas = String.valueOf(getNumOfSodas());
		String numOfMeals = String.valueOf(getNumOfMeals());
		
		this.orderAllItemsProperty = new SimpleStringProperty(numOfBurritos + " x Burritos, " + numOfFries + " x Fries, "
				+ numOfSodas + " x Sodas, " + numOfMeals + " x Meals.");
	}
	
	public StringProperty getOrderAllItems()
	{
		return orderAllItemsProperty;
	}
	
	
	//This is for order date
	public String getDate()
	{
		return orderDateProperty.get();
	}
	
	public void setOrderDate(String orderDate)
	{
		this.orderDateProperty.set(orderDate);
	}
	
	public StringProperty getOrderDate()
	{
		return orderDateProperty;
	}
	
	//This is for order time
	public String getTime()
	{
		return orderTimeProperty.get();
	}
	
	public void setOrderTime(String orderTime)
	{
		this.orderTimeProperty.set(orderTime);
	}
	
	public StringProperty getOrderTime()
	{
		return orderTimeProperty;
	}
	
	//This is for order total cost
	public double getTotalCost()
	{
		return orderTotalCostProperty.get();
	}
	
	public void setOrderTotalCost(double orderTotalCost)
	{
		this.orderTotalCostProperty.set(orderTotalCost);
	}
	
	public DoubleProperty getOrderTotalCost()
	{
		return orderTotalCostProperty;
	}
	
	
	//This is for order status
	public String getStatus()
	{
		return orderStatusProperty.get();
	}
	
	public void setOrderStatus(String orderStatus)
	{
		this.orderStatusProperty.set(orderStatus);
	}
	
	public StringProperty getOrderStatus()
	{
		return orderStatusProperty;
	}
}
