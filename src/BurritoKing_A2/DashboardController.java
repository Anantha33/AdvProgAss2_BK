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
	Pages pages = new Pages();
	
	String currentFName = UserSingleton.getInstance().getCurrentFName();
	String currentLName = UserSingleton.getInstance().getCurrentLName();
	boolean currentIsVIP = UserSingleton.getInstance().getCurrentVIPStatus();
	
	@FXML
	public Label userFullName;
	public Button upgradeUserButton;
	
	public void displayFullName()
	{
		userFullName.setText(currentFName + " " + currentLName);
	}
	
	
	public void openCart(ActionEvent event) throws IOException
	{
		pages.cartPage(event);
	}
	

	public void openProfilePage(ActionEvent event) throws IOException
	{
		pages.profilePage(event);
	}
	
	
	public void viewAllOrders(ActionEvent event) throws IOException
	{
		pages.allOrdersPage(event);
	}
	
	
	public void openLoginPage(ActionEvent event) throws IOException
	{
		pages.loginPage(event);
	}
	
	
	public void openUpgradeProfile(ActionEvent event) throws IOException
	{
		pages.upgradeProfilePage(event);
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
