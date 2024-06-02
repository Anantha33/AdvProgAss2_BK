package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

//This class helps the user with the addition of food items, as well as calculating the cost and time of the particular order
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
	private double numOfFriesOrderedInTotal;
	private double numOfFriesBatchesInTotal;
	private static double numOfFriesRemainingAfterCurrentOrder;
	private double timeForFriesPreparation;
	private double friesMaxPerBatch = 5;
	private int timeForFries = 8;
	
	double numOfMealsToBePrepared;
	double timeForMealPrep;
	
	//Checking the values of the items and proceeding to the order details page
	public void openOrderDetailsPage(ActionEvent event) throws IOException 
	{
		if (burritoTF.getText().isBlank())
		{
			numOfBurritosOrdered = 0;
		}
		else
		{
			numOfBurritosOrdered = Integer.parseInt(burritoTF.getText());
		}
		
		if (friesTF.getText().isBlank())
		{
			numOfFriesOrdered = 0;
		}
		else
		{
			numOfFriesOrdered = Integer.parseInt(friesTF.getText());
		}
		
		if (sodaTF.getText().isBlank())
		{
			numOfSodasOrdered = 0;
		}
		else
		{
			numOfSodasOrdered = Integer.parseInt(sodaTF.getText());
		}
		
		if (UserSingleton.getInstance().getCurrentVIPStatus())
		{
			numOfMealsOrdered = Integer.parseInt(mealTF.getText());
		}
		else
		{
			numOfMealsOrdered = 0;
		}
		
		if (numOfBurritosOrdered == 0 && numOfFriesOrdered == 0 && numOfSodasOrdered == 0 && numOfMealsOrdered == 0)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Cart can't have 0 items!");
            alert.showAndWait();
		}
		else
		{
			//Burrito preparation time
			timeForBurritoPreparation = (Math.ceil(numOfBurritosOrdered/burritosMaxPerBatch) * timeForBurrito);
			
			numOfFriesOrderedInTotal = numOfFriesOrdered + numOfMealsOrdered;
			
			//Fries preparation time (Total number of fries also accounted for)
			if (numOfFriesOrderedInTotal > numOfFriesLeft)
			{
				numOfFriesBatchesInTotal = Math.ceil(numOfFriesOrderedInTotal/friesMaxPerBatch);
				
				numOfFriesRemainingAfterCurrentOrder = (numOfFriesBatchesInTotal * friesMaxPerBatch) - (numOfFriesOrderedInTotal) + 
						(numOfFriesLeft);
				
				timeForFriesPreparation = (numOfFriesBatchesInTotal * timeForFries);
			}
			
			//Checking if there are fries in the warming tray
			else if (numOfFriesOrderedInTotal <= numOfFriesLeft)
			{
				numOfFriesRemainingAfterCurrentOrder = numOfFriesLeft - numOfFriesOrderedInTotal;
				timeForFriesPreparation = 0;
			}
			
			//Time to prepare a meal
			timeForMealPrep = (Math.ceil((numOfMealsOrdered + numOfBurritosOrdered)/burritosMaxPerBatch) * timeForBurrito);
			
			//Setting the order details
			OrderDetailsSingleton.getInstance().setCurrentOrderDetails(numOfBurritosOrdered, numOfFriesOrdered, 
					numOfSodasOrdered, numOfMealsOrdered, OrderDetailsSingleton.getInstance().getCurrentNumOfFriesLeft(), 
					totalOrderCost(), getTimeForOrder());
			
			pages.orderDetailsPage(event);
		}
	}
	
	//Returning the fries that remain after current order
	public static double getFriesRemainingAfterCurrentOrder()
	{	
		return numOfFriesRemainingAfterCurrentOrder;
	}
	
	//Returning the time taken to prepare an order
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
	
	//Returning the total cost of the order
	public double totalOrderCost()
	{
		double totalCost = numOfBurritosOrdered * Price.priceOfBurrito + numOfFriesOrdered * Price.priceOfFries + 
				numOfSodasOrdered * Price.priceOfSoda + numOfMealsOrdered * Price.priceOfMeal;
		return totalCost;
	}
	
	//Opening the dashboard page
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		pages.dashboardPage(event);
		burritoTF.clear();
		friesTF.clear();
		sodaTF.clear();
		mealTF.clear();
	}
	
	//Regex implementation to handle invalid inputs
	public void numOfBurritosTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			burritoTF.backward();
			burritoTF.deleteNextChar();
		}
	}
	
	//Regex implementation to handle invalid inputs
	public void numOfFriesTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			friesTF.backward();
			friesTF.deleteNextChar();
		}
	}
	
	//Regex implementation to handle invalid inputs
	public void numOfSodasTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			sodaTF.backward();
			sodaTF.deleteNextChar();
		}
	}
	
	//Regex implementation to handle invalid inputs
	public void numOfMealsTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			mealTF.backward();
			mealTF.deleteNextChar();
		}
	}
	
	//Setting the values of the respective item textfields and checking if the user is a VIP or not (for ordering meals)
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