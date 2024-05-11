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
	private Stage signUpStage;
	private Scene signUpScene;
	
	private String existingUsername = "Andy";
	
	private Parent root;
	
	@FXML
	public TextField usernameTF;
	public PasswordField passwordTF;
	public PasswordField cPasswordTF;
	public TextField firstNameTF;
	public TextField lastNameTF;
	
	
	public void showSignUpPage(ActionEvent event) throws IOException
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
		 if (usernameTF.getText().isBlank() || passwordTF.getText().isBlank() || cPasswordTF.getText().isBlank() || 
				 firstNameTF.getText().isBlank() || lastNameTF.getText().isBlank())
		 {
			 System.out.println("Fields cannot be empty");
		 }
		 else if (!passwordTF.getText().equals(cPasswordTF.getText()))
		 {
			 System.out.println("Please enter identical passwords");
		 }
		 else if (usernameTF.getText().equals(existingUsername))
		 {
			 System.out.println("The username already exists");
		 }
		 else
		 {
			 LoginController login = new LoginController();
			 login.showLoginPage(event);
		 }
	 }
	
	
	public void openWelcomePage(ActionEvent event) throws IOException
	 {
		 WelcomeController welcome = new WelcomeController();
		 welcome.showWelcomePage(event);
	 }
}
