package BurritoKing_A2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.*;

public class LoginController 
{
	private Stage dashboardStage;
	private Scene dashboardScene;
	
	private Stage welcomeStage;
	private Scene welcomeScene;

	private Parent root;
	
	@FXML
	public TextField usernameTF;
	
	@FXML
	public PasswordField passwordTF;
	
	@FXML
	public Label errorMessage;
	
	public void openDashboard(ActionEvent event) throws IOException
	{
		if (usernameTF.getText().equals("Andy") && passwordTF.getText().equals("axy"))
		{
			root = FXMLLoader.load(getClass().getResource("/Dashboard.fxml"));
			dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			dashboardStage.setTitle("Dashboard");
			dashboardScene = new Scene(root);
			dashboardStage.setScene(dashboardScene);
			dashboardStage.show();
		}
		else
		{
			errorMessage.setText("Invalid username or password!");
			//System.out.println("Invalid username or password!");
		}
	}
	
	public void openWelcomePage(ActionEvent event) throws IOException
	 {
		 root = FXMLLoader.load(getClass().getResource("/WelcomePage.fxml"));
		 welcomeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 welcomeStage.setTitle("Welcome Page");
		 welcomeScene = new Scene(root);
		 welcomeStage.setScene(welcomeScene);
		 welcomeStage.show();
	 }
}
