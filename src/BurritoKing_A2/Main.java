package BurritoKing_A2;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
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
	
	
	public static void connect() 
	{  
        Connection conn = null;  
        try 
        {  
            //DB Parameters  
            String url = "jdbc:sqlite:C:/Sqlite/AdvProgA2.db";  
            //Creating a connection to the database  
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        } 
        finally 
        {  
            try 
            {  
                if (conn != null) 
                {  
                    conn.close();  
                }  
            } 
            catch (SQLException ex) 
            {  
                System.out.println(ex.getMessage());  
            }  
        }  
    }  
	
	 
	public static void main(String[] args) 
	{
		connect();
		launch();
	}
}
