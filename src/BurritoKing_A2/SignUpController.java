package BurritoKing_A2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.fxml.*;


//This class handles the signing up of a new user
public class SignUpController 
{	
	Pages pages = new Pages();
	@FXML
	public TextField usernameTF;
	public PasswordField passwordTF;
	public PasswordField cPasswordTF;
	public TextField firstNameTF;
	public TextField lastNameTF;
	
	//Showing the login page if the user is registered successfully
	public void openLoginPage(ActionEvent event) throws IOException
	{ 
		if (usernameTF.getText().isBlank() || passwordTF.getText().isBlank() || cPasswordTF.getText().isBlank() || 
				 firstNameTF.getText().isBlank() || lastNameTF.getText().isBlank())
		{
			showAlert("Error", "Please fill in all fields.");
		}
		else if (!passwordTF.getText().equals(cPasswordTF.getText()))
		{
			showAlert("Error", "Passwords do not match.");
		}
		else if (Database.isUsernameExists(usernameTF.getText()))
		{
			showAlert("Error", "Username already exists.");
		}
		else
		{
			Database.insertNewUser(usernameTF.getText(), passwordTF.getText(), firstNameTF.getText(), lastNameTF.getText());
			showAlert("Success", "Registration successful. You can now log in.");
			pages.loginPage(event);
		}
		 
	}
	
	private void showAlert(String title, String message) 
	{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
	
	@FXML
	public void openWelcomePage(ActionEvent event) throws IOException
	{
		try
		{
			pages.welcomePage(event);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Regex implementation to handle invalid inputs
	public void firstNameTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^a-zA-Z]"))
		{
			event.consume();
			
			firstNameTF.backward();
			firstNameTF.deleteNextChar();
		}
	}
	
	//Regex implementation to handle invalid inputs
	public void lastNameTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^a-zA-Z]"))
		{
			event.consume();
			
			lastNameTF.backward();
			lastNameTF.deleteNextChar();
		}
	}
	
	//Regex implementation to handle invalid inputs
	public void usernameTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^a-zA-Z0-9_.]"))
		{
			event.consume();
			
			usernameTF.backward();
			usernameTF.deleteNextChar();
		}
	}
}
