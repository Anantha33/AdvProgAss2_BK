package BurritoKing_A2;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Login
{
	String inputUname;
	String inputPword;
	String test = "Andy";
	
	public void loginPage()
	{
		try
		{
			Stage loginStage = new Stage();
			loginStage.setTitle("Login Page");
			
			Pane loginPane = new Pane();
			
			
			Label usernameLabel = new Label("Username: ");
			usernameLabel.setId("usernameLabel");
			usernameLabel.setLayoutX(1);
			usernameLabel.setLayoutY(20);
			
			TextField usernameTF = new TextField();
			usernameTF.setId("usernameTF");
			usernameTF.setLayoutX(100);
			usernameTF.setLayoutY(22);
			
			
			Label passwordLabel = new Label("Password: ");
			passwordLabel.setId("passwordLabel");
			passwordLabel.setLayoutX(1);
			passwordLabel.setLayoutY(80);
			
			PasswordField passwordTF = new PasswordField();
			passwordTF.setId("passwordTF");
			passwordTF.setLayoutX(100);
			passwordTF.setLayoutY(82);
			
			
			Button loginSubmit = new Button("Submit");
			loginSubmit.setId("loginSubmit");
			loginSubmit.setLayoutX(1);
			loginSubmit.setLayoutY(142);
			
			Button backToWelcome = new Button("Welcome Page");
			backToWelcome.setId("backToWelcome");
			backToWelcome.setLayoutX(140);
			backToWelcome.setLayoutY(142);
			
			Label errorMessage = new Label();
			errorMessage.setId("errorMessage");
			errorMessage.setLayoutX(15);
			errorMessage.setLayoutY(202);
			
			backToWelcome.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event)
				{
					Main welcome = new Main();
					Stage welcomeStage = new Stage();
					welcome.start(welcomeStage);
					loginStage.close();
				}
			});
			
			
			loginSubmit.setOnAction(new EventHandler<ActionEvent>() 
			{
			    @Override
			    public void handle(ActionEvent event) 
			    {
			    	if(usernameTF.getText().equals(test) && passwordTF.getText().equals("Axy"))
			    	{
			    		System.out.println("Success");
			    		end();
			    	}
			    	else
			    	{
			    		errorMessage.setText("Incorrect Username or Password!");
			    	}
			    }
			});
			
//			loginSubmit.addEventHandler(MouseEvent.MOUSE_ENTERED,
//					new EventHandler<MouseEvent>()
//			{
//			    @Override
//			    public void handle(MouseEvent event) 
//			    {
//			    	inputUname = usernameTF.getText();
//			    	inputPword = passwordTF.getText();
//			    	//System.out.println(inputUname);
//			    	//System.out.println(inputPword);
//			    }
//			});
//			
//			loginSubmit.addEventHandler(MouseEvent.MOUSE_CLICKED, 
//			new EventHandler<MouseEvent>()
//			{
//				@Override
//				public void handle(MouseEvent event)
//				{
//			    	System.out.println(inputUname);
//			    	if (test == "Andy")
//			    	{
//			    		System.out.println("Success");
//			    	}
//					//end();
//					/*System.out.println(inputUname);
//					System.out.println(inputPword);*/
//				}
//			});
			
			
			loginPane.getChildren().add(usernameLabel);
			loginPane.getChildren().add(usernameTF);
			
			loginPane.getChildren().add(passwordLabel);
			loginPane.getChildren().add(passwordTF);
			
			loginPane.getChildren().add(loginSubmit);
			loginPane.getChildren().add(backToWelcome);
			
			loginPane.getChildren().add(errorMessage);
			
			Scene loginPanescene = new Scene(loginPane, 270, 250);
			loginPanescene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
			
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
