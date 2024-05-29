package BurritoKing_A2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class EditProfileController 
{
	Pages pages = new Pages();
	
	@FXML
	public TextField newFirstNameTF;
	public TextField newLastNameTF;
	public PasswordField newPasswordTF;
	public PasswordField cNewPasswordTF;
	
	public void updateFirstName(ActionEvent event) throws IOException
	{
		if (newFirstNameTF.getText().isBlank())
		{
			showAlert("Error", "New first name cannot be null");
		}
		else
		{
			Database.updateFirstName(newFirstNameTF.getText());
			UserSingleton.getInstance().setCurrentUserDetails(UserSingleton.getInstance().getCurrentUsername(), 
					newFirstNameTF.getText(), UserSingleton.getInstance().getCurrentLName(), 
					UserSingleton.getInstance().getCurrentVIPStatus());
			showAlert("Success", "First name updated successfully!");
		}
	}
	
	
	public void updateLastName(ActionEvent event) throws IOException
	{
		if (newLastNameTF.getText().isBlank())
		{
			showAlert("Error", "New last name cannot be null");
		}
		else
		{
			Database.updateLastName(newLastNameTF.getText());
			UserSingleton.getInstance().setCurrentUserDetails(UserSingleton.getInstance().getCurrentUsername(), 
					UserSingleton.getInstance().getCurrentFName(), newLastNameTF.getText(), 
					UserSingleton.getInstance().getCurrentVIPStatus());
			showAlert("Success", "Last name updated successfully!");
		}
	}
	
	
	public void updatePassword(ActionEvent event) throws IOException
	{
		if (newPasswordTF.getText().isBlank() || cNewPasswordTF.getText().isBlank())
		{
			showAlert("Error", "Fields cannot be empty!");
		}
		
		else if (!cNewPasswordTF.getText().equals(newPasswordTF.getText()))
		{
			showAlert("Error", "Passwords do not match!");
		}
		
		else
		{
			Database.updatePassword(newPasswordTF.getText());
			showAlert("Success", "Password updated successfully!");
		}
	}
	
	
	public void openProfilePage(ActionEvent event) throws IOException
	{
		pages.profilePage(event);
	}
	
	private void showAlert(String title, String message) 
	{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
	
	public void newFNameTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^a-zA-Z]"))
		{
			event.consume();
			
			newFirstNameTF.backward();
			newFirstNameTF.deleteNextChar();
		}
	}
	
	
	public void newLNameTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^a-zA-Z]"))
		{
			event.consume();
			
			newLastNameTF.backward();
			newLastNameTF.deleteNextChar();
		}
	}
}
