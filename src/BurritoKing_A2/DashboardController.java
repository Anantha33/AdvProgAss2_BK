package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.*;

public class DashboardController implements Initializable
{
	Scene profilePageScene;
	Stage profilePageStage;
	
	String currentUsername;
	
	String currentFName = UserSingleton.getInstance().getCurrentFName();
	String currentLName = UserSingleton.getInstance().getCurrentLName();
	boolean currentIsVIP = UserSingleton.getInstance().getCurrentVIPStatus();
	
	
	@FXML
	private Button profilePageButton;
	public Label userFullName;
	public Button upgradeUserButton;
	
	public void displayFullName()
	{
		/*System.out.println(this.currentFName);
		System.out.println(this.currentLName);*/
		//currentUsername = firstname;
		userFullName.setText(currentFName + " " + currentLName);
	}
	
	
	public void openCart(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cart.fxml"));
		Parent root = loader.load();
		Scene cartScene = new Scene(root);
		Stage cartStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		cartStage.setTitle("Cart");
		cartStage.setScene(cartScene);
		cartStage.show();
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
	
	
	public void openUpgradeProfile(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/UpgradeProfilePage.fxml"));
		Parent root = loader.load();
		Scene upgradeProfileScene = new Scene(root);
		Stage upgradeProfileStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		upgradeProfileStage.setScene(upgradeProfileScene);
		upgradeProfileStage.setTitle("Upgrade Profile Page");
		upgradeProfileStage.show();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		if (currentIsVIP)
		{
			upgradeUserButton.setDisable(true);
		}
		else
		{
			upgradeUserButton.setDisable(false);
		}
		
	}
}
