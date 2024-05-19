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
	
	
	public void openEditFirstName(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditFNamePage.fxml"));
		Scene editFNameScene = new Scene(loader.load());
		Stage editFNameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		editFNameStage.setTitle("Edit First Name");
		editFNameStage.setScene(editFNameScene);
		editFNameStage.show();
	}
	
	
	public void openEditLastName(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditLNamePage.fxml"));
		Scene editLNameScene = new Scene(loader.load());
		Stage editLNameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		editLNameStage.setTitle("Edit Last Name");
		editLNameStage.setScene(editLNameScene);
		editLNameStage.show();
	}
	
	
	public void openEditPassword(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditPasswordPage.fxml"));
		Scene editPasswordScene = new Scene(loader.load());
		Stage editPasswordStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		editPasswordStage.setTitle("Edit Last Name");
		editPasswordStage.setScene(editPasswordScene);
		editPasswordStage.show();
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
