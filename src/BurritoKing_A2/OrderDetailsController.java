package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class OrderDetailsController implements Initializable
{
	Pages pages = new Pages();
	

	public Label burritosLabel;
	public Label friesLabel;
	public Label sodasLabel;
	public Label mealsLabel;
	public Label totalCost;
	public Label totalPrepTime;
	
	public void openCart(ActionEvent event) throws IOException
	{
		pages.cartPage(event);
	}
	
	public void openPaymentPage(ActionEvent event) throws IOException
	{
		pages.paymentPage(event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		burritosLabel.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfBurritos()));
		friesLabel.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfFries()));
		sodasLabel.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfSodas()));
		mealsLabel.setText(String.valueOf(OrderDetailsSingleton.getInstance().getCurrentNumOfMeals()));
		totalCost.setText("$" + String.valueOf(OrderDetailsSingleton.getInstance().getCurrentTotalCost()));
	}
}
