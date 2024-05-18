package BurritoKing_A2;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  


public class Main extends Application 
{	
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
	
	public static void main(String[] args) 
	{
		//connect();
		launch();
	}
}
