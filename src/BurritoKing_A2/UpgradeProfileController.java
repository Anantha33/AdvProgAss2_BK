package BurritoKing_A2;

import java.io.IOException;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpgradeProfileController
{
	Pages pages = new Pages();
	
	@FXML
	public CheckBox promotionCheckbox;
	public TextField emailTF;
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		pages.dashboardPage(event);
	}
	
	
	public void upgradeUser()
	{
		if (emailTF.getText().isBlank())
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Email cannot be null!");
            alert.showAndWait();
		}
		else
		{
			if (isValidEmail(emailTF.getText()))
			{
				Database.upgradeUser(emailTF.getText(), UserSingleton.getInstance().getCurrentUsername());
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	            alert.setTitle("Success");
	            alert.setHeaderText(null);
	            alert.setContentText("Please log out and log in again to access VIP functionalities!");
	            alert.showAndWait();
			}
			else
			{
				Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Error");
	            alert.setHeaderText(null);
	            alert.setContentText("Invalid Email entered!");
	            alert.showAndWait();
			}
		}
	}
	
	
	private boolean isValidEmail(String email)
	{
		String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(email).matches();
	}
	
	public void checkboxFunction(ActionEvent event)
	{
		if (promotionCheckbox.isSelected())
		{
			emailTF.setDisable(false);
		}
		else
		{
			emailTF.setDisable(true);
		}
	}
}
