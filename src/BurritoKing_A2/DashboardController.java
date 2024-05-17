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
	Main main = new Main();
	
	Scene profilePageScene;
	Stage profilePageStage;
	
	String currentUsername;
	
	String currentFName = UserSingleton.getInstance().getCurrentFName();
	String currentLName = UserSingleton.getInstance().getCurrentLName();
	
	
	@FXML
	private Button profilePageButton;
	public Label userFName;
	public Label userLName;
	public Label activeOrder;
	
	Pages pages = new Pages();
	
	public void displayFName()
	{
		/*System.out.println(this.currentFName);
		System.out.println(this.currentLName);*/
		//currentUsername = firstname;
		userFName.setText(currentFName);
	}
	
	public void displayLName()
	{
		userLName.setText(currentLName);
	}
	

	public void openProfilePage(ActionEvent event) throws IOException
	{
		//main.openProfilePage();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ProfilePage.fxml"));
		profilePageScene = new Scene(fxmlLoader.load());
		
		ProfileController pc = fxmlLoader.getController();
		pc.displayCurrentUsername();
		//pc.setPreScene(profilePageButton.getScene());
		
		profilePageStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		profilePageStage.setTitle("Profile Page");
		profilePageStage.setScene(profilePageScene);
		profilePageStage.show();
		//pages.profilePage(event);
		//activeOrder.setText("hello");
	}
	
	
	public void openLoginPage(ActionEvent event) throws IOException
	{
		main.openLoginPage();
		//System.out.println(activeOrder.getText());
		/*CurrentUser x = CurrentUser.getInstance();
		System.out.println(x.currentFName);*/
		//System.out.println(currentUsername);
		//pages.loginPage(event);
	}
	
	public void getCurrentUsername(String username)
	{
		currentUsername = username;
	}
	
	public void setActiveOrder()
	{
		activeOrder.setText("hello");
	}
}
