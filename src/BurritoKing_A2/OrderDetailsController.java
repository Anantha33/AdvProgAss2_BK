package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

//This class shows the user what they have ordered, before initiating the payment
public class OrderDetailsController implements Initializable
{
	Pages pages = new Pages();
	
	@FXML
	public Label burritosLabel;
	public Label friesLabel;
	public Label sodasLabel;
	public Label mealsLabel;
	public Label totalCost;
	public Label totalPrepTime;
	public Button redeemCreditsButton;
	
	public void openCart(ActionEvent event) throws IOException
	{
		pages.cartPage(event);
	}
	
	public void openPaymentPage(ActionEvent event) throws IOException
	{
		pages.paymentPage(event);
	}
	
	public void openRedeemCreditsPage(ActionEvent event) throws IOException
	{
		pages.redeemCreditsPage(event);
	}
	
	//Showing the number of all items the user has ordered
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		burritosLabel.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfBurritos()));
		friesLabel.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfFries()));
		sodasLabel.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfSodas()));
		mealsLabel.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfMeals()));
		totalCost.setText("$" + String.valueOf(OrderDetailsSingleton.getInstance().getCurrentTotalCost()));
		totalPrepTime.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentPrepTime()) + " minutes");
		
		//Allows the user to redeem credits if the user is a VIP
		if (UserSingleton.getInstance().getCurrentVIPStatus())
		{
			redeemCreditsButton.setDisable(false);
		}
		else
		{
			redeemCreditsButton.setDisable(true);
		}
		
		CreditsController.currentOrderCreditsRedeemed = 0;
		CreditsController.newTotalOrderCost = OrderDetailsSingleton.getInstance().getCurrentTotalCost();
	}
}
