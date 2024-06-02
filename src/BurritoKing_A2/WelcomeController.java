package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;

//This class helps the user navigate to either the sign up page or the login page
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
