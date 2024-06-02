package BurritoKing_A2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

//The main class of the program
public class Main extends Application 
{	
	//Shows the welcome page at the start of the program
	@Override
	public void start(Stage welcomeStage) 
	{
		try 
		{
			welcomeStage.setTitle("Welcome Page");
			Parent root = FXMLLoader.load(getClass().getResource("/WelcomePage.fxml"));
			Scene welcomeScene = new Scene(root);
			welcomeStage.setScene(welcomeScene);
			welcomeStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	//Launching the program
	public static void main(String[] args) 
	{
		launch();
	}
}
