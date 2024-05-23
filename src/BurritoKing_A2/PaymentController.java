package BurritoKing_A2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PaymentController 
{
	Pages pages = new Pages();
	
	@FXML
	public TextField cardNumberTF;
	public TextField expDateTF;
	public PasswordField cvvTF;
	public TextField orderTimeTF;
	
	public void openOrderDetailsPage(ActionEvent event) throws IOException
	{
		pages.orderDetailsPage(event);
	}
	
	public void openConfirmationPage()
	{
		if (cardNumberTF.getText().length() != 16 || cvvTF.getText().length() != 3)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid card details");
            alert.showAndWait();
		}
		else if (orderTimeTF.getText().isBlank())
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a time");
            alert.showAndWait();
		}
		else
		{
			Database.newOrder();
			System.out.println(CartController.getFriesRemainingAfterCurrentOrder());
			OrderDetailsSingleton.getInstance().setCurrentOrderDetails(0, 0, 0, 0, CartController.getFriesRemainingAfterCurrentOrder(), 0);
		}
	}
}
