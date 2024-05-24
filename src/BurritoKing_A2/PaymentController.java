package BurritoKing_A2;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

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
	
	public void openConfirmationPage(ActionEvent event) throws IOException
	{
		if (cardNumberTF.getText().isBlank() || cvvTF.getText().isBlank() || expDateTF.getText().isBlank())
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Fields cannot be blank!");
            alert.showAndWait();
		}
		
		else if (cardNumberTF.getText().length() != 16 || cvvTF.getText().length() != 3)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid card details!");
            alert.showAndWait();
		}
		else if (!isValidDate(expDateTF.getText()))
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Wrong date format!");
            alert.showAndWait();
		}
		else if (orderTimeTF.getText().isBlank())
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a time!");
            alert.showAndWait();
		}
		else if (!isValidTime(orderTimeTF.getText()))
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Wrong time format!");
            alert.showAndWait();
		}
		else
		{
			Database.newOrder(orderTimeTF.getText());
			OrderDetailsSingleton.getInstance().setCurrentOrderDetails(0, 0, 0, 0, CartController.getFriesRemainingAfterCurrentOrder(), 
					0, 0);
			
			String latestOrderID = String.valueOf(Database.latestOrderID());
			
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Order placed successfully! \n" + "Order ID: " + latestOrderID);
            alert.showAndWait();
            
            pages.dashboardPage(event);
		}
	}
	
	
	public void cardNumberTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			cardNumberTF.backward();
			cardNumberTF.deleteNextChar();
		}
	}
	
	public void expDateTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9/]"))
		{
			event.consume();
			
			expDateTF.backward();
			expDateTF.deleteNextChar();
		}
	}
	
	public void cvvTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			cvvTF.backward();
			cvvTF.deleteNextChar();
		}
	}
	
	public void orderTimeTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9:]"))
		{
			event.consume();
			
			orderTimeTF.backward();
			orderTimeTF.deleteNextChar();
		}
	}
	
	public static boolean isValidTime(String time)
	{
		String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		Pattern p = Pattern.compile(regex);
		if (time == null) 
		{
            return false;
        }
		Matcher m = p.matcher(time);
		return m.matches();
	}
	
	public static boolean isValidDate(String date)
	{
		String regex = "([0]?[1-9]|1[0-2])/[0-9][0-9]";
		Pattern p = Pattern.compile(regex);
		if (date == null)
		{
			return false;
		}
		Matcher m = p.matcher(date);
		return m.matches();
	}
}
