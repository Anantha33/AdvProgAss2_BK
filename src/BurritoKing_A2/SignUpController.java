package BurritoKing_A2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.fxml.*;

public class SignUpController 
{	
	Pages pages = new Pages();
	@FXML
	public TextField usernameTF;
	public PasswordField passwordTF;
	public PasswordField cPasswordTF;
	public TextField firstNameTF;
	public TextField lastNameTF;
	
	
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
			 try (Connection conn = Database.getConnection()) 
		        {
		            String query = "INSERT INTO Customer (Username, Password, firstName, lastName) VALUES (?, ?, ?, ?)";
		            PreparedStatement stmt = conn.prepareStatement(query);
		            stmt.setString(1, usernameTF.getText());
		            stmt.setString(2, passwordTF.getText());
		            stmt.setString(3, firstNameTF.getText());
		            stmt.setString(4, lastNameTF.getText());
		            stmt.executeUpdate();

		            showAlert("Success", "Registration successful. You can now log in.");
		            
		            pages.loginPage(event);
		        } 
		        catch (SQLException e) 
		        {
		            e.printStackTrace();
		            showAlert("Error", "An error occurred during registration.");
		        }
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
	
	public void firstNameTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^a-zA-Z]"))
		{
			event.consume();
			
			firstNameTF.backward();
			firstNameTF.deleteNextChar();
		}
	}
	
	public void lastNameTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^a-zA-Z]"))
		{
			event.consume();
			
			lastNameTF.backward();
			lastNameTF.deleteNextChar();
		}
	}
	
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
