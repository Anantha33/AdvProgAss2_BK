package BurritoKing_A2;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.event.ActionEvent;

public class Pages 
{
	private Stage welcomeStage;
	private Scene welcomeScene;
	
	private Stage loginStage;
	private Scene loginScene;
	
	private Stage signUpStage;
	private Scene signUpScene;
	
	private Stage dashboardStage;
	private Scene dashboardScene;
	
	private Stage profileStage;
	private Scene profileScene;
	
	private Parent root;
	
	
	
	public void welcomePage(ActionEvent event) throws IOException
	 {
		 root = FXMLLoader.load(getClass().getResource("/WelcomePage.fxml"));
		 welcomeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 welcomeStage.setTitle("Welcome Page");
		 welcomeScene = new Scene(root);
		 welcomeStage.setScene(welcomeScene);
		 welcomeStage.show();
	 }
	
	public void loginPage(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
		loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		loginStage.setTitle("Login Page");
		loginScene = new Scene(root);
		loginStage.setScene(loginScene);
		loginStage.show();
	}
	
	public void signUpPage(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("/SignUpPage.fxml"));
		signUpStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		signUpStage.setTitle("Sign Up Page");
		signUpScene = new Scene(root);
		signUpStage.setScene(signUpScene);
		signUpStage.show();
	}
	
	public void dashboardPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Dashboard.fxml"));
		root = loader.load();
		//root = FXMLLoader.load(getClass().getResource("/Dashboard.fxml"));
		dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		dashboardStage.setTitle("Dashboard");
		dashboardScene = new Scene(root);
		//System.out.println(x);
		dashboardStage.setScene(dashboardScene);
		dashboardStage.show();
	}
	
	public void profilePage(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("/ProfilePage.fxml"));
		profileStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		profileStage.setTitle("Profile Page");
		profileScene = new Scene(root);
		profileStage.setScene(profileScene);
		profileStage.show();
	}
}
