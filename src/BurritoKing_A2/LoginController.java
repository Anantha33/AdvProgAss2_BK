package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException; 

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
}
