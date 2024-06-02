package BurritoKing_A2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

//This class handles the updation of first and last names, as well as the password of the user
public class EditProfileController 
{
	Pages pages = new Pages();
	
	@FXML
	public TextField newFirstNameTF;
	public TextField newLastNameTF;
	public PasswordField newPasswordTF;
	public PasswordField cNewPasswordTF;
	
	//Updating the first name
	public void updateFirstName(ActionEvent event) throws IOException
	{
		if (newFirstNameTF.getText().isBlank())
		{
			showAlert("Error", "New first name cannot be null");
		}
		else if (newFirstNameTF.getText().equals(UserSingleton.getInstance().getCurrentFName()))
		{
			showAlert("Error", "New first name is the same as the previous one!");
		}
		else
		{
			Database.updateFirstName(newFirstNameTF.getText());
			UserSingleton.getInstance().setCurrentUserDetails(UserSingleton.getInstance().getCurrentUsername(), 
					newFirstNameTF.getText(), UserSingleton.getInstance().getCurrentLName(), 
					UserSingleton.getInstance().getCurrentVIPStatus(), UserSingleton.getInstance().getCurrentCredits());
			showAlert("Success", "First name updated successfully!");
			
			pages.profilePage(event);
		}
	}
	
	//Updating the last name
	public void updateLastName(ActionEvent event) throws IOException
	{
		if (newLastNameTF.getText().isBlank())
		{
			showAlert("Error", "New last name cannot be null");
		}
		else if (newLastNameTF.getText().equals(UserSingleton.getInstance().getCurrentLName()))
		{
			showAlert("Error", "New last name is the same as the previous one!");
		}
		else
		{
			Database.updateLastName(newLastNameTF.getText());
			UserSingleton.getInstance().setCurrentUserDetails(UserSingleton.getInstance().getCurrentUsername(), 
					UserSingleton.getInstance().getCurrentFName(), newLastNameTF.getText(), 
					UserSingleton.getInstance().getCurrentVIPStatus(), UserSingleton.getInstance().getCurrentCredits());
			showAlert("Success", "Last name updated successfully!");
			
			pages.profilePage(event);
		}
	}
	
	//Updating the password
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
		
		else if (newPasswordTF.getText().equals(Database.getPassword(UserSingleton.getInstance().getCurrentUsername())))
		{
			showAlert("Error", "New password is the same as the previous one!");
		}
		
		else
		{
			Database.updatePassword(newPasswordTF.getText());
			showAlert("Success", "Password updated successfully!");
			
			pages.profilePage(event);
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
	
	//Regex implementation to handle invalid inputs
	public void newFNameTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^a-zA-Z]"))
		{
			event.consume();
			
			newFirstNameTF.backward();
			newFirstNameTF.deleteNextChar();
		}
	}
	
	//Regex implementation to handle invalid inputs
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
