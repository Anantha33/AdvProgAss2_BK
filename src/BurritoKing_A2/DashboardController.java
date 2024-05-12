package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.*;

public class DashboardController 
{
	@FXML
	public Label userFName;
	public Label userLName;
	
	Pages pages = new Pages();
	
	public void setUserFName(ActionEvent event) throws IOException
	{
		System.out.println(userFName.getText());
	}
	
	
	public void getUserFName()
	{
		System.out.println(userFName.getText());
	}
	
	
	public void openProfilePage(ActionEvent event) throws IOException
	{
		pages.profilePage(event);
	}
	
	
	public void openLoginPage(ActionEvent event) throws IOException
	{
		pages.loginPage(event);
	}
}
