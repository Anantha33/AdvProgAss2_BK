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
	private Stage dashboardStage;
	
	Pages pages = new Pages();
	
	@FXML
	Label currentUsername;
	Label currentFName;
	Label currentLName;
	
	private Scene preScene;
	
	public void setPreScene(Scene preScene)
	{
		this.preScene = preScene;
	}
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		dashboardStage.setScene(preScene);
		dashboardStage.show();
	}
	
	public void displayCurrentUsername(String username)
	{
		currentUsername.setText(username);
	}
	
	public void displayCurrentFName(String fName)
	{
		currentFName.setText(fName);
	}
	
	public void displayCurrentLName(String lName)
	{
		currentLName.setText(lName);
	}
}
