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

public class CreditsController implements Initializable
{
	Pages pages = new Pages();
	
	@FXML
	public Label currentCreditsLabel;
	public TextField creditsTF;
	
	public static double currentOrderCreditsRedeemed = 0;
	public static double newTotalOrderCost = OrderDetailsSingleton.getInstance().getCurrentTotalCost();
	
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
		else
		{
			currentOrderCreditsRedeemed = Double.parseDouble(creditsTF.getText());
			newTotalOrderCost -= (currentOrderCreditsRedeemed / 100);
			System.out.println(currentOrderCreditsRedeemed);
			System.out.printf("%,.2f \n", newTotalOrderCost);
			System.out.printf("You will be getting a discount of %,.2f \n", Double.parseDouble(creditsTF.getText()) / 100 );
			pages.paymentPage(event);
		}
		
		
//			System.out.println(currentOrderCreditsRedeemed);
//			System.out.printf("%,.2f \n", newTotalOrderCost);
	}
	
	
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
		
	}

}
