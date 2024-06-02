package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

//This class handles the redeeming of credits of a VIP user
public class CreditsController implements Initializable
{
	Pages pages = new Pages();
	
	@FXML
	public Label currentCreditsLabel;
	public TextField creditsTF;
	
	public static double currentOrderCreditsRedeemed;
	public static double newTotalOrderCost;
	
	public void openOrderDetailsPage(ActionEvent event) throws IOException
	{
		pages.orderDetailsPage(event);
	}
	
	public void openPaymentPage(ActionEvent event) throws IOException
	{
		if (creditsTF.getText().isBlank())
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter credits!");
            alert.showAndWait();
		}
		else if (Double.parseDouble(creditsTF.getText()) > Database.getCurrentCredits(UserSingleton.getInstance().getCurrentUsername())
				|| Database.getCurrentCredits(UserSingleton.getInstance().getCurrentUsername()) == 0)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You don't have enough credits!");
            alert.showAndWait();
		}
		else
		{
			//Updating the total order cost
			currentOrderCreditsRedeemed = Double.parseDouble(creditsTF.getText());
			newTotalOrderCost -= (currentOrderCreditsRedeemed / 100);
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congratulations!");
            alert.setHeaderText(null);
            alert.setContentText("You get a discount of $" + (currentOrderCreditsRedeemed / 100) + " \n" +
            "New Total Cost = $" + newTotalOrderCost);
            alert.showAndWait();
            
			pages.paymentPage(event);
		}
	}
	
	//Regex implementation to handle invalid inputs
	public void creditsTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			creditsTF.backward();
			creditsTF.deleteNextChar();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		currentCreditsLabel.setText(String.valueOf(Database.getCurrentCredits(UserSingleton.getInstance().getCurrentUsername())));
		currentOrderCreditsRedeemed = 0;
		newTotalOrderCost = OrderDetailsSingleton.getInstance().getCurrentTotalCost();
	}

}
