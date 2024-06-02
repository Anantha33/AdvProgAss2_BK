package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


//This class shows the user the profile details, whilst giving them the opportunity to change the details (except username)
public class ProfileController implements Initializable
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

	//Displaying the username, first, and last names
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		currentUName.setText(currentusername);
		currentFName.setText(currentFirstName);
		currentLName.setText(currentLastName);
	}
}
