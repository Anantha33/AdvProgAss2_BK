package BurritoKing_A2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.fxml.*;

public class SignUpController 
{
	private Stage loginStage;
	private Scene loginScene;
	
	private Stage welcomeStage;
	private Scene welcomeScene;
	
	private Parent root;
	
	@FXML
	public TextField usernameTF;
	public PasswordField passwordTF;
	public PasswordField cPasswordTF;
	public TextField firstNameTF;
	public TextField lastNameTF;
	
	public void openLoginPage(ActionEvent event) throws IOException
	 {
		 if (usernameTF.getText().isBlank() || passwordTF.getText().isBlank() || cPasswordTF.getText().isBlank() || 
				 firstNameTF.getText().isBlank() || lastNameTF.getText().isBlank())
		 {
			 System.out.println("Fields cannot be empty");
		 }
		 else if (!passwordTF.getText().equals(cPasswordTF.getText()))
		 {
			 System.out.println("Please enter identical passwords");
		 }
		 else
		 {
			 root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
			 loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			 loginStage.setTitle("Login Page");
			 loginScene = new Scene(root);
			 loginStage.setScene(loginScene);
			 loginStage.show();
		 }
	 }
	
	
	public void openWelcomePage(ActionEvent event) throws IOException
	 {
		 root = FXMLLoader.load(getClass().getResource("/WelcomePage.fxml"));
		 welcomeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 welcomeStage.setTitle("Welcome Page");
		 welcomeScene = new Scene(root);
		 welcomeStage.setScene(welcomeScene);
		 welcomeStage.show();
	 }
}
