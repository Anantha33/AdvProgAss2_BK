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
	UserSingleton cUser = new UserSingleton();
	String currentFName = cUser.currentFName;
	String currentLName = cUser.currentLName;
	Stage mainStage = new Stage();
	
	public Stage getMainStage()
	{
		return mainStage;
	}
	
	/*@Override
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
	}*/
	
	@Override
	public void start(Stage mainStage) throws IOException
	{
		try
		{
			this.mainStage = mainStage;
			//openDashboardPage();
			openWelcomePage();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		connect();
		launch();
	}
	
	public void openWelcomePage() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/WelcomePage.fxml"));
		Parent root = loader.load();
		Scene welcomeScene = new Scene(root);
		WelcomeController wc = loader.getController();
		wc.setMainApp(this);
		mainStage.setScene(welcomeScene);
		mainStage.setTitle("Welcome Page");
		mainStage.show();
	}
	
	public void openSignUpPage() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUpPage.fxml"));
		Parent root = loader.load();
		Scene signUpScene = new Scene(root);
		SignUpController sc = new SignUpController();
		sc.setMainApp(this);
		mainStage.setScene(signUpScene);
		mainStage.setTitle("Sign Up Page");
		mainStage.show();
	}
	
	public void openLoginPage() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginPage.fxml"));
		Scene loginScene = new Scene(loader.load());
		LoginController lc = new LoginController();
		mainStage.setScene(loginScene);
		mainStage.setTitle("Login Page");
		mainStage.show();
	}
	
	public void openDashboardPage() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Dashboard.fxml"));
		Scene dashboardScene = new Scene(loader.load());
		DashboardController dc = loader.getController();
		//dc.displayFName(currentFName);
		//dc.displayLName(currentLName);
		mainStage.setScene(dashboardScene);
		mainStage.setTitle("Dashboard");
		mainStage.show();
	}
	
	public void openProfilePage() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProfilePage.fxml"));
		Scene profilePageScene = new Scene(loader.load());
		ProfileController pc = new ProfileController();
		pc.displayCurrentLName(currentLName);
		mainStage.setScene(profilePageScene);
		mainStage.setTitle("Profile Page");
		mainStage.show();
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
	
	 
	/*public static void main(String[] args) 
	{
		connect();
		launch();
	}*/
}
