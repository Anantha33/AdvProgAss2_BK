package BurritoKing_A2;
	
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


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
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year  = localDate.getYear();
		int month = localDate.getMonthValue();
		int day   = localDate.getDayOfMonth();
		System.out.println(month);
		System.out.println(year);
		launch();
	}
}
