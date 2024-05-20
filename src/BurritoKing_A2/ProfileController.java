package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ProfileController 
{	
	Pages pages = new Pages();
	String currentusername = UserSingleton.getInstance().getCurrentUsername();
	String currentFirstName = UserSingleton.getInstance().getCurrentFName();
	String currentLastName = UserSingleton.getInstance().getCurrentLName();
	
	@FXML
	public Label currentUName;
	public Label currentFName;
	public Label currentLName;
	
	
	public void openEditFirstName(ActionEvent event) throws IOException
	{
		pages.editFNamePage(event);
	}
	
	
	public void openEditLastName(ActionEvent event) throws IOException
	{
		pages.editLNamePage(event);
	}
	
	
	public void openEditPassword(ActionEvent event) throws IOException
	{
		pages.editPasswordPage(event);
	}
	
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		pages.dashboardPage(event);
	}
	
	
	public void displayCurrentUsername()
	{
		currentUName.setText(currentusername);
	}
	
	public void displayCurrentFName()
	{
		currentFName.setText(currentFirstName);
	}
	
	public void displayCurrentLName()
	{
		currentLName.setText(currentLastName);
	}
}
