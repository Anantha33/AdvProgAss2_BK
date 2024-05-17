package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;

public class WelcomeController 
{
	 private Main mainApp;
	 //Main mainApp = new Main();
	 
	 public void openSignUpPage(ActionEvent event) throws IOException
	 { 
		 mainApp.openSignUpPage();
	 }
	 
	 
	 public void openLoginPage(ActionEvent event) throws IOException
	 {
		 mainApp.openLoginPage();
	 }
	 
	 public void setMainApp(Main mainApp)
	 {
		 this.mainApp = mainApp;
	 }
}
