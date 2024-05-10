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
	 private Stage signUpStage;
	 private Scene signUpScene;
	 
	 private Stage loginStage;
	 private Scene loginScene;
	 
	 private Parent root;
	 
	 public void openSignUpPage(ActionEvent event) throws IOException
	 {
		 root = FXMLLoader.load(getClass().getResource("/SignUpPage.fxml"));
		 signUpStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 signUpStage.setTitle("Sign Up Page");
		 signUpScene = new Scene(root);
		 signUpStage.setScene(signUpScene);
		 signUpStage.show();
	 }
	 
	 public void openLoginPage(ActionEvent event) throws IOException
	 {
		 root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
		 loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 loginStage.setTitle("Login Page");
		 loginScene = new Scene(root);
		 loginStage.setScene(loginScene);
		 loginStage.show();
	 }
}
