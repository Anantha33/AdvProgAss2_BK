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
	Pages pages = new Pages();
	
	 public void openSignUpPage(ActionEvent event) throws IOException
	 { 
		 pages.signUpPage(event);
	 }
	 
	 
	 public void openLoginPage(ActionEvent event) throws IOException
	 {
		 pages.loginPage(event);
	 }
}
