package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.*;

public class DashboardController 
{
	Main main = new Main();
	
	Scene profilePageScene;
	Stage profilePageStage;
	
	String currentUsername;
	
	String currentFName = UserSingleton.getInstance().getCurrentFName();
	String currentLName = UserSingleton.getInstance().getCurrentLName();
	
	
	@FXML
	private Button profilePageButton;
	public Label userFullName;
	
	public void displayFullName()
	{
		/*System.out.println(this.currentFName);
		System.out.println(this.currentLName);*/
		//currentUsername = firstname;
		userFullName.setText(currentFName + " " + currentLName);
	}

	public void openProfilePage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProfilePage.fxml"));
		Parent root = loader.load();
		Scene profileScene = new Scene(root);
		ProfileController pc = loader.getController();
		pc.displayCurrentUsername();
		pc.displayCurrentFName();
		pc.displayCurrentLName();
		Stage profileStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		profileStage.setTitle("Profile Page");
		profileStage.setScene(profileScene);
		profileStage.show();
	}
	
	
	public void viewAllOrders(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllOrders.fxml"));
		Parent root = loader.load();
		Scene allOrderScene = new Scene(root);
		Stage allOrderStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		allOrderStage.setScene(allOrderScene);
		allOrderStage.setTitle("All Orders");
		allOrderStage.show();
	}
	
	
	public void openLoginPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginPage.fxml"));
		Parent root = loader.load();
		Scene loginScene = new Scene(root);
		LoginController lc = loader.getController();
		Stage loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		loginStage.setScene(loginScene);
		loginStage.setTitle("Login Page");
		loginStage.show();
	}
}
