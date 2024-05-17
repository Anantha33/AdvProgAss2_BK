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
	Main main = new Main();
	
	Pages pages = new Pages();
	
	String currentFullName = UserSingleton.getInstance().getCurrentFName();
	
	@FXML
	public Label currentUsername;
	public Label currentFName;
	public Label currentLName;
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Dashboard.fxml"));
		Scene dashboardScene = new Scene(fxmlLoader.load());
		DashboardController dc = fxmlLoader.getController();
		//dc.getCurrentUsername(usernameTF.getText());
		dc.displayFName();
		dc.displayLName();
		Stage dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		dashboardStage.setTitle("Dashboard");
		dashboardStage.setScene(dashboardScene);
		dashboardStage.show();
		dc.setActiveOrder();
		//main.openDashboardPage();
		/*dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		dashboardStage.setScene(preScene);
		dashboardStage.show();*/
	}
	
	public void getCurrentFName(String fName)
	{
		currentFullName = fName;
		System.out.println(currentFullName);
	}
	
	public void displayCurrentUsername()
	{
		currentUsername.setText(currentFullName);
	}
	
	public void displayCurrentFName()
	{
		
	}
	
	public void displayCurrentLName(String lName)
	{
		System.out.println(lName);
		currentLName.setText(lName);
	}
}
