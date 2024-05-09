package BurritoKing_A2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

public class SignUp 
{
	public void signUpPage()
	{
		try
		{
			Stage signUpStage = new Stage();
			signUpStage.setTitle("SignUp Page");
			
			Pane signUpPane = new Pane();
			
			Label usernameLabel = new Label("Enter username: ");
			usernameLabel.setId("usernameLabel");
			usernameLabel.setLayoutX(1);
			usernameLabel.setLayoutY(10);
			
			TextField usernameTF = new TextField();
			usernameTF.setId("username");
			usernameTF.setLayoutX(140);
			usernameTF.setLayoutY(12);
			
			Label passwordLabel = new Label("Enter password: ");
			passwordLabel.setId("passwordLabel");
			passwordLabel.setLayoutX(1);
			passwordLabel.setLayoutY(60);
			
			PasswordField passwordTF = new PasswordField();
			passwordTF.setId("passwordTF");
			passwordTF.setLayoutX(140);
			passwordTF.setLayoutY(62);
			
			Label firstNameLabel = new Label("Enter first name: ");
			firstNameLabel.setId("firstNameLabel");
			firstNameLabel.setLayoutX(1);
			firstNameLabel.setLayoutY(110);
			
			TextField firstNameTF = new TextField();
			firstNameTF.setId("firstNameTF");
			firstNameTF.setLayoutX(140);
			firstNameTF.setLayoutY(112);
			
			Label lastNameLabel = new Label("Enter last name: ");
			lastNameLabel.setId("lastNameLabel");
			lastNameLabel.setLayoutX(1);
			lastNameLabel.setLayoutY(160);
			
			TextField lastNameTF = new TextField();
			lastNameTF.setId("lastNameTF");
			lastNameTF.setLayoutX(140);
			lastNameTF.setLayoutY(162);
			
			Button signUpSubmit = new Button("Submit");
			signUpSubmit.setId("test");
			signUpSubmit.setLayoutX(170);
			signUpSubmit.setLayoutY(220);
			
			signUpSubmit.setOnAction(new EventHandler<ActionEvent>() 
			{
			    @Override
			    public void handle(ActionEvent event) 
			    {
			        System.out.println("Username: " + usernameTF.getText());
			        System.out.println("Password: " + passwordTF.getText());
			        System.out.println("First Name: " + firstNameTF.getText());
			        System.out.println("Last Name: " + lastNameTF.getText());
			        //signUpStage.close();
			    }
			});
			
			Button backToWelcome = new Button("Welcome Page");
			backToWelcome.setId("backToWelcome");
			backToWelcome.setLayoutX(143);
			backToWelcome.setLayoutY(285);
			
			backToWelcome.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event)
				{
					Main welcome = new Main();
					Stage welcomeStage = new Stage();
					welcome.start(welcomeStage);
					signUpStage.close();
				}
			});
			
			signUpPane.getChildren().add(usernameLabel);
			signUpPane.getChildren().add(usernameTF);
			
			signUpPane.getChildren().add(passwordLabel);
			signUpPane.getChildren().add(passwordTF);
			
			signUpPane.getChildren().add(firstNameLabel);
			signUpPane.getChildren().add(firstNameTF);
			
			signUpPane.getChildren().add(lastNameLabel);
			signUpPane.getChildren().add(lastNameTF);
			
			signUpPane.getChildren().add(signUpSubmit);
			signUpPane.getChildren().add(backToWelcome);
			
			Scene signUpPanescene = new Scene(signUpPane, 400, 400);
			signUpPanescene.getStylesheets().add(getClass().getResource("SignUp.css").toExternalForm());
			signUpStage.setScene(signUpPanescene);
			signUpStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
