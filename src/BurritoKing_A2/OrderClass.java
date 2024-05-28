package BurritoKing_A2;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrderClass 
{
	private IntegerProperty orderIDProperty;
	private StringProperty orderDateProperty;
	private StringProperty orderTimeProperty;
	private DoubleProperty orderTotalCostProperty;
	private StringProperty orderStatusProperty;
	
	public OrderClass()
	{
		this.orderIDProperty = new SimpleIntegerProperty();
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
