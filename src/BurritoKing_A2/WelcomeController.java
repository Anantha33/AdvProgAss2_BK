package BurritoKing_A2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WelcomeController 
{
	 /*private Stage signUpStage;
	 private Scene signUpScene;
	 
	 private Stage loginStage;
	 private Scene loginScene;*/
	 private Stage welcomeStage;
	 private Scene welcomeScene;
	 
	 private Parent root;
	
	 public void showWelcomePage(ActionEvent event) throws IOException
	 {
		 root = FXMLLoader.load(getClass().getResource("/WelcomePage.fxml"));
		 welcomeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 welcomeStage.setTitle("Welcome Page");
		 welcomeScene = new Scene(root);
		 welcomeStage.setScene(welcomeScene);
		 welcomeStage.show();
	 }
	 
	 public void openSignUpPage(ActionEvent event) throws IOException
	 {
		 SignUpController signUp = new SignUpController();
		 signUp.showSignUpPage(event);
	 }
	 
	 public void openLoginPage(ActionEvent event) throws IOException
	 {
		 LoginController login = new LoginController();
		 login.showLoginPage(event);
	 }
}
