package BurritoKing_A2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.*;
import javafx.scene.layout.*;

public class Login
{
	
	public void loginPage()
	{
		try
		{
			Stage loginStage = new Stage();
			loginStage.setTitle("Login Page");
			
			Pane loginPane = new Pane();
			Label username = new Label("Username: ");
			Label password = new Label("Password: ");
			Button submit = new Button("Submit");
			
			submit.setOnAction(new EventHandler<ActionEvent>() 
			{
			    @Override
			    public void handle(ActionEvent event) 
			    {
			    	end();
			        System.out.println("Button clicked");
			        loginStage.close();
			    }
			});
			
			
			loginPane.getChildren().add(username);
			loginPane.getChildren().add(password);
			loginPane.getChildren().add(submit);
			
			Scene loginPanescene = new Scene(loginPane, 400, 400);
			loginStage.setScene(loginPanescene);
			loginStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	public void end()
	{
		Stage thirdStage = new Stage();
		thirdStage.setTitle("Third dialog box");
		Pane third = new Pane();
		
		Scene thirdscene = new Scene(third, 400, 400);
		thirdStage.setScene(thirdscene);
		thirdStage.show();
	}
}
