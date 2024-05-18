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
	String currentusername = UserSingleton.getInstance().getCurrentUsername();
	String currentFirstName = UserSingleton.getInstance().getCurrentFName();
	String currentLastName = UserSingleton.getInstance().getCurrentLName();
	
	@FXML
	public Label currentUName;
	public Label currentFName;
	public Label currentLName;
	
	
	public void openEditProfile(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditProfilePage.fxml"));
		Scene editProfileScene = new Scene(loader.load());
		Stage editProfileStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		editProfileStage.setTitle("Edit Profile");
		editProfileStage.setScene(editProfileScene);
		editProfileStage.show();
	}
	
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Dashboard.fxml"));
		Scene dashboardScene = new Scene(loader.load());
		DashboardController dc = loader.getController();
		dc.displayFullName();
		Stage dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		dashboardStage.setTitle("Dashboard");
		dashboardStage.setScene(dashboardScene);
		dashboardStage.show();
	}
	
	public void getCurrentFName(String fName)
	{
		/*currentFirstName = fName;
		System.out.println(currentFullName);*/
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
