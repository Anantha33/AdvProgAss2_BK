package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.fxml.*;

//This class handles the login of a user
public class LoginController 
{	
	Pages pages = new Pages();
	private String firstName;
	private String lastName;
	private boolean vipStatus;
	private double credits;
	
	@FXML
	public TextField usernameTF;
	public PasswordField passwordTF;
	
	//Opens the dashboard if there is a successful login, otherwise shows an error
	public void openDashboard(ActionEvent event) throws IOException
	{	
		if (Database.authenticateUser(usernameTF.getText(), passwordTF.getText()))
		{	
			firstName = Database.getFirstName(usernameTF.getText());
			lastName = Database.getLastName(usernameTF.getText());
			vipStatus = Database.getVIPStatus(usernameTF.getText());
			credits = Database.getCurrentCredits(usernameTF.getText());
			UserSingleton.getInstance().setCurrentUserDetails(usernameTF.getText(), firstName, lastName, vipStatus, credits);
            
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText(null);
            alert.setContentText("Successfully logged in! \n" + "Welcome aboard, " + usernameTF.getText() + "!");
            alert.showAndWait();
            
			pages.dashboardPage(event);
		}
		else
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password!");
            alert.showAndWait();
		}
	}
	
	
	public void openWelcomePage(ActionEvent event) throws IOException
	{
		pages.welcomePage(event);
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
