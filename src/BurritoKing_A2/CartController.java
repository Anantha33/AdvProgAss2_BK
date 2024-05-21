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
	
	private int numOfBurritos;
	private int numOfFries;
	private int numOfSodas;
	private int numOfMeals;
	
	private double burritosMaxPerBatch = 2;
	private int timeForBurrito = 9;
	private double timeForBurritoPreparation;
	
	private double numOfFriesToBePrepared;
	private double timeForFriesPreparation;
	private double friesMaxPerBatch = 5;
	private int timeForFries = 8;
	
	double numOfMealsToBePrepared;
	double timeForMealPrep;
	
	public void openOrderDetailsPage(ActionEvent event) throws IOException
	{
		numOfBurritos = Integer.parseInt(burritoTF.getText());
		numOfFries = Integer.parseInt(friesTF.getText());
		numOfSodas = Integer.parseInt(sodaTF.getText());
		
		if (UserSingleton.getInstance().getCurrentVIPStatus())
		{
			numOfMeals = Integer.parseInt(mealTF.getText());
		}
		else
		{
			numOfMeals = 0;
		}
		
		//Burrito preparation time
		timeForBurritoPreparation = (Math.ceil(numOfBurritos/burritosMaxPerBatch) * timeForBurrito);
		//System.out.println(timeForBurritoPreparation);
		
		//Fries preparation time
		if (numOfFries > OrderDetailsSingleton.getInstance().getCurrentNumOfFriesLeft())
		{
			timeForFriesPreparation = (Math.ceil(numOfFries/friesMaxPerBatch) * timeForFries);
		}
		else
		{
			timeForFriesPreparation = 0;
		}
		//System.out.println(timeForFriesPreparation);
		
		timeForMealPrep = (Math.ceil(numOfMeals/burritosMaxPerBatch) * timeForBurrito);
		
		//System.out.println(totalOrderCost());
		
		//System.out.println(getTimeForOrder());
		
		OrderDetailsSingleton.getInstance().setCurrentOrderDetails(numOfBurritos, numOfFries, numOfSodas, numOfMeals, totalOrderCost(), OrderDetailsSingleton.getInstance().getCurrentNumOfFriesLeft());
		pages.orderDetailsPage(event);
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
		double totalCost = numOfBurritos * Price.priceOfBurrito + numOfFries * Price.priceOfFries + 
				numOfSodas * Price.priceOfSoda + numOfMeals * Price.priceOfMeal;
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
		
		/*SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE);
		valueFactory.setValue(0);
		
		burritoSpinner.setValueFactory(valueFactory);
		friesSpinner.setValueFactory(valueFactory);
		sodaSpinner.setValueFactory(valueFactory);*/
		
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
