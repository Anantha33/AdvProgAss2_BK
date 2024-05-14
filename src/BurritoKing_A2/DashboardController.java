package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.*;

public class DashboardController 
{
	Scene profilePageScene;
	Stage profilePageStage;
	
	String currentUsername;
	
	
	@FXML
	private Button profilePageButton;
	public Label userFName;
	public Label userLName;
	
	Pages pages = new Pages();
	
	public void displayFName(String firstname)
	{
		currentUsername = firstname;
		userFName.setText(firstname);
	}
	
	public void displayLName(String lastname)
	{
		userLName.setText(lastname);
	}
	

	public void openProfilePage(ActionEvent event) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ProfilePage.fxml"));
		profilePageScene = new Scene(fxmlLoader.load());
		
		ProfileController pc = fxmlLoader.getController();
		pc.setPreScene(profilePageButton.getScene());
		
		profilePageStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		profilePageStage.setScene(profilePageScene);
		profilePageStage.show();
		//pages.profilePage(event);
	}
	
	
	public void openLoginPage(ActionEvent event) throws IOException
	{
		
		//System.out.println(currentUsername);
		pages.loginPage(event);
	}
}
