package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CartController implements Initializable
{
	Pages pages = new Pages();
	
	@FXML
	public TextField burritoTF;
	public TextField friesTF;
	public TextField sodaTF;
	public TextField mealTF;
	
	private int numOfBurritosOrdered;
	private int numOfFriesOrdered;
	private int numOfSodasOrdered;
	private int numOfMealsOrdered;

	
	private double burritosMaxPerBatch = 2;
	private int timeForBurrito = 9;
	private double timeForBurritoPreparation;
	
	private double numOfFriesLeft = OrderDetailsSingleton.getInstance().getCurrentNumOfFriesLeft();
	private double numOfFriesBatchesToBePrepared;
	private static double numOfFriesRemainingAfterCurrentOrder;
	private double timeForFriesPreparation;
	private double friesMaxPerBatch = 5;
	private int timeForFries = 8;
	
	double numOfMealsToBePrepared;
	double timeForMealPrep;
	
	public void openOrderDetailsPage(ActionEvent event) throws IOException
	{
		numOfBurritosOrdered = Integer.parseInt(burritoTF.getText());
		numOfFriesOrdered = Integer.parseInt(friesTF.getText());
		numOfSodasOrdered = Integer.parseInt(sodaTF.getText());
		
		if (UserSingleton.getInstance().getCurrentVIPStatus())
		{
			numOfMealsOrdered = Integer.parseInt(mealTF.getText());
		}
		else
		{
			numOfMealsOrdered = 0;
		}
		
		//Burrito preparation time
		timeForBurritoPreparation = (Math.ceil(numOfBurritosOrdered/burritosMaxPerBatch) * timeForBurrito);
		//System.out.println(timeForBurritoPreparation);
		
		//Fries preparation time
		if (numOfFriesOrdered > numOfFriesLeft)
		{
			numOfFriesBatchesToBePrepared = Math.ceil(numOfFriesOrdered/friesMaxPerBatch);
			
			numOfFriesRemainingAfterCurrentOrder = (numOfFriesBatchesToBePrepared * friesMaxPerBatch) - (numOfFriesOrdered) + 
					(numOfFriesLeft);
			
			timeForFriesPreparation = (numOfFriesBatchesToBePrepared * timeForFries);
		}
		
		else if (numOfFriesOrdered <= numOfFriesLeft)
		{
			numOfFriesRemainingAfterCurrentOrder = numOfFriesLeft - numOfFriesOrdered;
			timeForFriesPreparation = 0;
		}
		
		timeForMealPrep = (Math.ceil(numOfMealsOrdered/burritosMaxPerBatch) * timeForBurrito);
		
		System.out.println(getFriesRemainingAfterCurrentOrder());
		
		OrderDetailsSingleton.getInstance().setCurrentOrderDetails(numOfBurritosOrdered, numOfFriesOrdered, 
				numOfSodasOrdered, numOfMealsOrdered, OrderDetailsSingleton.getInstance().getCurrentNumOfFriesLeft(), 
				totalOrderCost());
		pages.orderDetailsPage(event);
	}
	
	public static double getFriesRemainingAfterCurrentOrder()
	{	
		return numOfFriesRemainingAfterCurrentOrder;
	}
	
	public double getTimeForOrder()
	{
		if (timeForMealPrep >= timeForBurritoPreparation && timeForMealPrep >= timeForFriesPreparation)
		{
			return timeForMealPrep;
		}
		else if (timeForBurritoPreparation >= timeForMealPrep && timeForBurritoPreparation >= 
				timeForFriesPreparation)
		{
			return timeForBurritoPreparation;
		}
		else
		{
			return timeForFriesPreparation;
		}
	}
	
	public double totalOrderCost()
	{
		double totalCost = numOfBurritosOrdered * Price.priceOfBurrito + numOfFriesOrdered * Price.priceOfFries + 
				numOfSodasOrdered * Price.priceOfSoda + numOfMealsOrdered * Price.priceOfMeal;
		return totalCost;
	}
	
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		pages.dashboardPage(event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		burritoTF.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfBurritos()));
		friesTF.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfFries()));
		sodaTF.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfSodas()));
		
		if (UserSingleton.getInstance().getCurrentVIPStatus())
		{
			mealTF.setDisable(false);
			mealTF.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfMeals()));
		}
		else
		{
			mealTF.setDisable(true);
		}
	}
}
