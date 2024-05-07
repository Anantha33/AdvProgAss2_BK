package BurritoKing_A2;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.*;
import javafx.scene.layout.*;


public class Main extends Application 
{
	@Override
	public void start(Stage welcomeStage) 
	{
		try 
		{
			welcomeStage.setTitle("Welcome Page");
			
			
			//Defining the pane for the welcome page
			Pane welcomeMessagePane = new Pane();
			welcomeMessagePane.getStyleClass().add("welcomeMessagePane");
			
			
			//Appropriate labels
			Label helloLabel = new Label("Welcome to Burrito King!");
			helloLabel.setId("helloLabel");
			helloLabel.setLayoutX(100);
			helloLabel.setLayoutY(40);
			
			
			Label signupLabel = new Label("Would you like to sign up?");
			signupLabel.setId("signupLabel");
			signupLabel.setLayoutX(95);
			signupLabel.setLayoutY(120);
			
			Button signUpButton = new Button("Sign Up");
			signUpButton.setId("signUpButton");
			signUpButton.setLayoutX(155);
			signUpButton.setLayoutY(160);
			signUpButton.setOnAction(new EventHandler<ActionEvent>()
					{
						@Override
						public void handle(ActionEvent event)
						{
							SignUp signUp = new SignUp();
							signUp.signUpPage();
							welcomeStage.close();
						}
					});
			
			
			Label loginLabel = new Label("Already a member?");
			loginLabel.setId("loginLabel");
			loginLabel.setLayoutX(125);
			loginLabel.setLayoutY(260);
			
			//Button for accessing the login page
			Button loginButton = new Button("Login");
			loginButton.setId("loginButton");
			loginButton.setLayoutX(165);
			loginButton.setLayoutY(300);
			loginButton.setOnAction(new EventHandler<ActionEvent>() 
			{
			    @Override
			    public void handle(ActionEvent event) 
			    {
			    	Login login = new Login();
			    	login.loginPage();
			    	welcomeStage.close();
			        //System.out.println("Button clicked");
			    }
			});
			
			
			welcomeMessagePane.getChildren().add(helloLabel);
			welcomeMessagePane.getChildren().add(signupLabel);
			welcomeMessagePane.getChildren().add(signUpButton);
			welcomeMessagePane.getChildren().add(loginLabel);
			welcomeMessagePane.getChildren().add(loginButton);
			
			
			//Creating a scene and placing it onto the stage
			Scene scene = new Scene(welcomeMessagePane,400,450);
			scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
			
			welcomeStage.setScene(scene);
			welcomeStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch();
	}
}
