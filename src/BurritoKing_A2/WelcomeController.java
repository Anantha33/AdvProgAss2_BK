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
	 private Main mainApp;
	 //Main mainApp = new Main();
	 
	 public void openSignUpPage(ActionEvent event) throws IOException
	 { 
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUpPage.fxml"));
		 Parent root = loader.load();
		 Scene signUpScene = new Scene(root);
		 SignUpController lc = loader.getController();
		 Stage signUpStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 signUpStage.setScene(signUpScene);
		 signUpStage.setTitle("Sign Up Page");
		 signUpStage.show();
	 }
	 
	 
	 public void openLoginPage(ActionEvent event) throws IOException
	 {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginPage.fxml"));
		 Parent root = loader.load();
		 Scene loginScene = new Scene(root);
		 LoginController lc = loader.getController();
		 Stage loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 loginStage.setScene(loginScene);
		 loginStage.setTitle("Login Page");
		 loginStage.show();
	 }
	 
	 public void setMainApp(Main mainApp)
	 {
		 this.mainApp = mainApp;
	 }
}
