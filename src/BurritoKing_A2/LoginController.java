package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.fxml.*;

public class LoginController 
{	
	Pages pages = new Pages();
	private String firstName;
	private String lastName;
	private boolean vipStatus;
	
	@FXML
	public TextField usernameTF;
	public PasswordField passwordTF;
	
	public void openDashboard(ActionEvent event) throws IOException
	{	
		if (Database.authenticateUser(usernameTF.getText(), passwordTF.getText()))
		{	
			firstName = Database.getFirstName(usernameTF.getText());
			lastName = Database.getLastName(usernameTF.getText());
			vipStatus = Database.getVIPStatus(usernameTF.getText());
			UserSingleton.getInstance().setCurrentUserDetails(usernameTF.getText(), firstName, lastName, vipStatus);
            
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText(null);
            alert.setContentText("Successfully logged in!");
            alert.showAndWait();
            
			pages.dashboardPage(event);
		}
		else
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password");
            alert.showAndWait();
		}
	}
	
	
	public void openWelcomePage(ActionEvent event) throws IOException
	 {
		pages.welcomePage(event);
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
